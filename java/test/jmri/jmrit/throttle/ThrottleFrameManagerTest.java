// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.throttle;

import java.awt.GraphicsEnvironment;

import jmri.InstanceManager;
import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.Assume;

/**
 * Test simple functioning of ThrottleFrameManager
 *
 * @author Paul Bender Copyright (C) 2016
 */
public class ThrottleFrameManagerTest {

    @Test
    public void testCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // the constructor is private, but invoked by instance.
        ThrottleFrameManager frame = InstanceManager.getDefault(ThrottleFrameManager.class);
        Assert.assertNotNull("exists", frame);
        frame.showThrottlesList();
        jmri.util.JUnitUtil.disposeFrame(Bundle.getMessage("ThrottleListFrameTile"),true,true);
    }

    @BeforeEach
    public void setUp() throws Exception {
        JUnitUtil.setUp();
        JUnitUtil.resetProfileManager();
    }

    @AfterEach
    public void tearDown() throws Exception {
        JUnitUtil.tearDown();
    }
}
