// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrix.dccpp.dccppovertcp;

import java.awt.GraphicsEnvironment;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

/**
 * Tests for ServerFrame class.
 *
 * @author Paul Bender Copyright (C) 2016
 */
public class ServerFrameTest extends jmri.util.JmriJFrameTestBase {

    @BeforeEach
    @Override
    public void setUp() {
        JUnitUtil.setUp();
        jmri.util.JUnitUtil.resetProfileManager();
        jmri.util.JUnitUtil.initDefaultUserMessagePreferences();
        jmri.jmrix.dccpp.DCCppSystemConnectionMemo memo = new jmri.jmrix.dccpp.DCCppSystemConnectionMemo();
        jmri.InstanceManager.setDefault(jmri.jmrix.dccpp.DCCppSystemConnectionMemo.class, memo);
        jmri.InstanceManager.getDefault(Server.class);
        if(!GraphicsEnvironment.isHeadless()){
           // ServerFrame is provided by InstanceManagerAutoInitialize
           frame = jmri.InstanceManager.getDefault(ServerFrame.class);
        }
    }

    @AfterEach
    @Override
    public void tearDown() {
        JUnitUtil.clearShutDownManager(); // put in place because AbstractMRTrafficController implementing subclass was not terminated properly
        super.tearDown();
    }

}
