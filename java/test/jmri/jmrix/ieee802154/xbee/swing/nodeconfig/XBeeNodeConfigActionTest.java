// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrix.ieee802154.xbee.swing.nodeconfig;

import java.awt.GraphicsEnvironment;

import jmri.InstanceManager;
import jmri.jmrix.ieee802154.xbee.XBeeConnectionMemo;
import jmri.jmrix.ieee802154.xbee.XBeeTrafficController;
import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.Assume;

/**
 * Test simple functioning of XBeeNodeConfigAction
 *
 * @author Paul Bender Copyright (C) 2016
 */
public class XBeeNodeConfigActionTest {

    @Test
    public void testStringMemoCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        XBeeNodeConfigAction action = new XBeeNodeConfigAction("IEEE 802.15.4 test Action", new XBeeConnectionMemo());
        Assert.assertNotNull("exists", action);
    }

    @Test
    public void testMemoCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        XBeeNodeConfigAction action = new XBeeNodeConfigAction( new XBeeConnectionMemo());
        Assert.assertNotNull("exists", action);
    }

    @Test
    public void testStringCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        XBeeConnectionMemo memo = new XBeeConnectionMemo();
        XBeeTrafficController tc = new XBeeTrafficController(){
            @Override
            protected jmri.jmrix.AbstractMRReply newReply() {
                return null;
            }
            @Override
            public jmri.jmrix.ieee802154.IEEE802154Node newNode() {
                return null;
            }
        };
        InstanceManager.setDefault(XBeeConnectionMemo.class, memo);
        memo.setTrafficController(tc);
        XBeeNodeConfigAction action = new XBeeNodeConfigAction("IEEE 802.15.4 test Action");
        Assert.assertNotNull("exists", action);
    }

    @Test
    public void testDefaultCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        XBeeConnectionMemo memo = new XBeeConnectionMemo();
        XBeeTrafficController tc = new XBeeTrafficController(){
            @Override
            protected jmri.jmrix.AbstractMRReply newReply() {
                return null;
            }
            @Override
            public jmri.jmrix.ieee802154.IEEE802154Node newNode() {
                return null;
            }
        };
        memo.setTrafficController(tc);
        InstanceManager.setDefault(XBeeConnectionMemo.class, memo);
        XBeeNodeConfigAction action = new XBeeNodeConfigAction();
        Assert.assertNotNull("exists", action);
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.clearShutDownManager(); // put in place because AbstractMRTrafficController implementing subclass was not terminated properly
        JUnitUtil.tearDown();
    
    }
}
