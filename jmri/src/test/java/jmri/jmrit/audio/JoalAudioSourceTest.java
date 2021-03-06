// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.audio;

import jmri.InstanceManager;
import jmri.jmrix.internal.InternalSystemConnectionMemo;
import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;
import org.junit.Assert;
import org.junit.Assume;

/**
 * Test simple functioning of JoalAudioSource
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class JoalAudioSourceTest {

    @Test
    public void testCtor() {
        Assume.assumeNotNull(JoalAudioFactory.getAL()); // Run test method only when JOAL is present.

        JoalAudioSource l = new JoalAudioSource("test");

        Assert.assertNotNull("exists", l);
        Assert.assertEquals("test", l.getSystemName());
        Assert.assertEquals(jmri.Audio.STATE_STOPPED, l.getState());
        Assert.assertEquals(0, l.numProcessedBuffers());
        Assert.assertEquals(0, l.numQueuedBuffers());
    }

    @Test
    public void testC2Stringtor() {
        JoalAudioSource l = new JoalAudioSource("testsysname","testusername");

        Assert.assertNotNull("exists", l);
        Assert.assertEquals("testsysname", l.getSystemName());
        Assert.assertEquals("testusername", l.getUserName());
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        jmri.AudioManager am = new DefaultAudioManager(InstanceManager.getDefault(InternalSystemConnectionMemo.class));
        jmri.InstanceManager.setDefault(jmri.AudioManager.class,am);
        am.init();
    }

    @AfterEach
    public void tearDown() {
        // this created an audio manager, clean that up
        InstanceManager.getDefault(jmri.AudioManager.class).cleanup();

        jmri.util.JUnitAppender.suppressErrorMessage("Unhandled audio format type 0");
        JUnitUtil.tearDown(); 
    }
}
