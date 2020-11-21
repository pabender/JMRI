// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.roster;

import jmri.util.JUnitUtil;
import jmri.util.JmriJFrame;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.jupiter.api.*;
import java.awt.GraphicsEnvironment;

/**
 *
 * @author Paul Bender Copyright (C) 2018
 */
public class PrintListActionTest {

    @Test
    public void testCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        JmriJFrame jf = new JmriJFrame("TestPrintListActionWindow");
        jmri.util.swing.WindowInterface wi = jf;
        PrintListAction t = new PrintListAction("test print action",wi);
        Assert.assertNotNull("exists",t);
        JUnitUtil.dispose(jf);
    }

    @BeforeEach
    public void setUp() {
        jmri.util.JUnitUtil.setUp();
        JUnitUtil.resetProfileManager();
    }

    @AfterEach
    public void tearDown() {
        jmri.util.JUnitUtil.tearDown();
    }

}
