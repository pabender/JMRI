// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.beantable;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class TurnoutTableTabActionTest extends AbstractTableTabActionBase {

    @Test
    public void testCTor() {
        Assert.assertNotNull("exists", a);
    }

    @Override
    public String getTableFrameName() {
        return Bundle.getMessage("TitleTurnoutTable");
    }

    /**
     * Check the return value of includeAddButton.
     * <p>
     * The table generated by this action includes an Add Button.
     */
    @Override
    @Test
    public void testIncludeAddButton() {
        Assert.assertTrue("Default include add button", a.includeAddButton());
    }

    @BeforeEach
    @Override
    public void setUp() {
        JUnitUtil.setUp();
        jmri.util.JUnitUtil.resetProfileManager();
        jmri.util.JUnitUtil.initInternalTurnoutManager();
        jmri.util.JUnitUtil.initDefaultUserMessagePreferences();
        helpTarget = "package.jmri.beantable.TurnoutTable";
        a = new TurnoutTableTabAction();
    }

    @AfterEach
    @Override
    public void tearDown() {
        a = null;
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(TurnoutTableTabActionTest.class);

}
