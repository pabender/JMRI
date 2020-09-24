// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.roster.swing.speedprofile;

import java.awt.GraphicsEnvironment;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class SpeedProfileFrameTest extends jmri.util.JmriJFrameTestBase {

    @BeforeEach
    @Override
    public void setUp() {
        JUnitUtil.setUp();
        JUnitUtil.resetProfileManager();
        JUnitUtil.initRosterConfigManager();
        if (!GraphicsEnvironment.isHeadless()) {
            frame = new SpeedProfileFrame();
        }
    }

    @AfterEach
    @Override
    public void tearDown() {
        JUnitUtil.deregisterBlockManagerShutdownTask();
        super.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(SpeedProfileFrameTest.class);
}
