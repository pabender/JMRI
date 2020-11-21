// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.sprog.packetgen;

import java.awt.GraphicsEnvironment;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

import jmri.jmrix.sprog.SprogSystemConnectionMemo;

/**
 * Test simple functioning of SprogPacketGenFrame 
 *
 * @author Paul Bender Copyright (C) 2016
 */
public class SprogPacketGenFrameTest extends jmri.util.JmriJFrameTestBase {

    private SprogSystemConnectionMemo memo;

    @BeforeEach
    @Override
    public void setUp() {
        JUnitUtil.setUp();
        memo = new SprogSystemConnectionMemo();
        if (!GraphicsEnvironment.isHeadless()) {
            frame = new SprogPacketGenFrame(memo);
        }
    }

    @AfterEach
    @Override
    public void tearDown() {
        memo.dispose();
        memo = null;
        JUnitUtil.clearShutDownManager(); // put in place because AbstractMRTrafficController implementing subclass was not terminated properly
        super.tearDown();
    }
}
