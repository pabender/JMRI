// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.lenz;

import jmri.Light;
import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tests for the jmri.jmrix.acela.AcelaTurnoutManager class.
 *
 * @author Paul Bender Copyright (C) 2010
 */
public class XNetLightManagerTest extends jmri.managers.AbstractLightMgrTestBase {

    XNetInterfaceScaffold xnis = null;

    @Override
    public String getSystemName(int i) {
        return "XL" + i;
    }

    @Test
    public void testctor(){
        // create and register the manager object
        XNetLightManager xlm = new XNetLightManager(xnis.getSystemConnectionMemo());
        Assert.assertNotNull(xlm);
    }

    @Test
    public void testAsAbstractFactory() {
        // ask for a Light, and check type
        Light tl = l.newLight("XL21", "my name");

        if (log.isDebugEnabled()) {
            log.debug("received light value {}", tl);
        }
        Assert.assertNotNull(tl);

        // make sure loaded into tables
        if (log.isDebugEnabled()) {
            log.debug("by system name: {}", l.getBySystemName("XL21"));
        }
        if (log.isDebugEnabled()) {
            log.debug("by user name:   {}", l.getByUserName("my name"));
        }

        Assert.assertNotNull(l.getBySystemName("XL21"));
        Assert.assertNotNull(l.getByUserName("my name"));
    }

    @Test
    public void testGetSystemPrefix(){
        // create and register the manager object
        XNetLightManager xlm = new XNetLightManager(xnis.getSystemConnectionMemo());
        Assert.assertEquals("prefix","X",xlm.getSystemPrefix());
    }

    @Test
    public void testAllowMultipleAdditions(){
        // create and register the manager object
        XNetLightManager xlm = new XNetLightManager(xnis.getSystemConnectionMemo());
        Assert.assertTrue(xlm.allowMultipleAdditions("foo"));
    }

    @Test
    public void testValidSystemNameConfig(){
        // create and register the manager object
        XNetLightManager xlm = new XNetLightManager(xnis.getSystemConnectionMemo());
        Assert.assertTrue(xlm.validSystemNameConfig("foo"));
    }



    // from here down is testing infrastructure
    @BeforeEach
    @Override
    public void setUp() {
        JUnitUtil.setUp();
        // prepare an interface, register
        xnis = new XNetInterfaceScaffold(new LenzCommandStation());
        // create and register the manager object
        l = new XNetLightManager(xnis.getSystemConnectionMemo()); // l is defined in AbstractLightMgrTestBase.
        jmri.InstanceManager.setLightManager(l);
        
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.clearShutDownManager(); // put in place because AbstractMRTrafficController implementing subclass was not terminated properly
        JUnitUtil.tearDown();
    }

    private final static Logger log = LoggerFactory.getLogger(XNetLightManagerTest.class);

}
