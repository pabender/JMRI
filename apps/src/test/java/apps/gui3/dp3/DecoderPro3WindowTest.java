// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package apps.gui3.dp3;

import java.awt.GraphicsEnvironment;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;
import org.junit.Assert;
import org.junit.Assume;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class DecoderPro3WindowTest {

    @Test
    public void testCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        DecoderPro3Window t = new DecoderPro3Window();
        Assert.assertNotNull("exists", t);
        JUnitUtil.dispose(t);
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        JUnitUtil.initDefaultUserMessagePreferences();
        JUnitUtil.resetProfileManager();
        JUnitUtil.initRosterConfigManager();
        JUnitUtil.initConnectionConfigManager();
        JUnitUtil.initDebugProgrammerManager();
        jmri.InstanceManager.setDefault(jmri.symbolicprog.ProgrammerConfigManager.class,new jmri.symbolicprog.ProgrammerConfigManager());
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(DecoderPro3WindowTest.class);
}
