// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.can.adapters.lawicell;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

/**
 * Tests for LawicellTrafficController.
 * @author Paul Bender Copyright (C) 2016
 */
public class LawicellTrafficControllerTest extends jmri.jmrix.can.TrafficControllerTest {
   
    @Override
    @BeforeEach
    public void setUp() {
        jmri.util.JUnitUtil.setUp(); 
        JUnitUtil.resetInstanceManager();
        tc = new LawicellTrafficController();
    }

    @Override
    @AfterEach
    public void tearDown(){
        tc = null;
        JUnitUtil.clearShutDownManager(); // put in place because AbstractMRTrafficController implementing subclass was not terminated properly
        JUnitUtil.tearDown();
 
    }

}
