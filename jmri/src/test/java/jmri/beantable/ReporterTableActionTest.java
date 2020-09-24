// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.beantable;

import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

import jmri.Reporter;
import jmri.util.JUnitUtil;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.jupiter.api.*;
import org.netbeans.jemmy.operators.JFrameOperator;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class ReporterTableActionTest extends AbstractTableActionBase<Reporter> {

    @Test
    public void testCTor() {
        Assert.assertNotNull("exists", a);
    }

    @Override
    public String getTableFrameName() {
        return Bundle.getMessage("TitleReporterTable");
    }

    @Override
    @Test
    public void testGetClassDescription() {
        Assert.assertEquals("Reporter Table Action class description", "Reporter Table", a.getClassDescription());
    }

    /**
     * Check the return value of includeAddButton. The table generated by this
     * action includes an Add Button.
     */
    @Override
    @Test
    public void testIncludeAddButton() {
        Assert.assertTrue("Default include add button", a.includeAddButton());
    }

    @Test
    @Override
    public void testAddButton() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        Assume.assumeTrue(a.includeAddButton());
        a.actionPerformed(null);
        JFrame f = JFrameOperator.waitJFrame(getTableFrameName(), true, true);

        // find the "Add... " button and press it.
        jmri.util.swing.JemmyUtil.pressButton(new JFrameOperator(f), Bundle.getMessage("ButtonAdd"));
        new org.netbeans.jemmy.QueueTool().waitEmpty();
        JFrame f1 = JFrameOperator.waitJFrame(getAddFrameName(), true, true);
        jmri.util.swing.JemmyUtil.pressButton(new JFrameOperator(f1), Bundle.getMessage("ButtonClose")); // not sure why this is close in this frame.
        JUnitUtil.dispose(f1);
        JUnitUtil.dispose(f);
    }

    @Override
    public String getAddFrameName() {
        return Bundle.getMessage("TitleAddReporter");
    }

    @Test
    @Override
    @Disabled("No Edit button on Reporter table")
    public void testEditButton() {
    }

    @Override
    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        jmri.util.JUnitUtil.resetProfileManager();
        helpTarget = "package.jmri.beantable.ReporterTable";
        a = new ReporterTableAction();
    }

    @Override
    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(ReporterTableActionTest.class);
}
