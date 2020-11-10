// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.roster;

import jmri.util.JUnitUtil;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class RosterRecorderTest {

    @Test
    public void testCTor() {
        RosterRecorder t = new RosterRecorder();
        Assert.assertNotNull("exists",t);
    }

    @BeforeEach
    public void setUp(@TempDir File folder) {
        JUnitUtil.setUp();
        try {
            JUnitUtil.resetProfileManager(new jmri.profile.NullProfile(folder));
        } catch (IOException ioe) {
            // failed to reset the profile relative to the temporary folder.
            // use the default reset.
            JUnitUtil.resetProfileManager();
        }
        JUnitUtil.initRosterConfigManager();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(RosterRecorderTest.class);

}
