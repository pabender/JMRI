// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.logix;

import java.awt.GraphicsEnvironment;

import jmri.roster.RosterEntry;
import jmri.roster.RosterSpeedProfile;
import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;
import org.junit.Assume;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class SpeedProfilePanelTest {

    @Test
    public void testCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        RosterSpeedProfile rsp = new RosterSpeedProfile(new RosterEntry());
        SpeedProfilePanel t = new SpeedProfilePanel(rsp, true, null);
        assertThat(t).withFailMessage("exists").isNotNull();
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.deregisterBlockManagerShutdownTask();
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(SpeedProfilePanelTest.class);

}
