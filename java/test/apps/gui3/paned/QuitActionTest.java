// SPDX-License-Identifier: GPL-2.0+
package apps.gui3.paned;

import java.awt.GraphicsEnvironment;

import jmri.util.JUnitUtil;
import jmri.util.swing.JFrameInterface;

import org.junit.jupiter.api.*;
import org.junit.Assert;
import org.junit.Assume;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class QuitActionTest {

    @Test
    public void testCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        JFrameInterface w = new JFrameInterface(new jmri.util.JmriJFrame("foo"));
        QuitAction t = new QuitAction("test",w);
        Assert.assertNotNull("exists",t);
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(QuitActionTest.class);

}
