// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.sprog.serialdriver;

import jmri.jmrix.sprog.SprogSystemConnectionMemo;
import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

/**
 * Tests for ConnectionConfig class.
 *
 * @author Paul Bender Copyright (C) 2016
 **/
public class ConnectionConfigTest extends jmri.jmrix.AbstractSerialConnectionConfigTestBase  {

   @BeforeEach
   @Override
   public void setUp() {
        JUnitUtil.setUp();

        JUnitUtil.initDefaultUserMessagePreferences();
        cc = new ConnectionConfig();
   }

   @AfterEach
   @Override
   public void tearDown(){
        if (cc != null) {
            if (cc.getAdapter() != null) {
                if (cc.getAdapter().getSystemConnectionMemo() != null) {
                    if (((SprogSystemConnectionMemo)cc.getAdapter().getSystemConnectionMemo()) != null) {
                        ((SprogSystemConnectionMemo)cc.getAdapter().getSystemConnectionMemo()).dispose();
                    }
                }
            }
        }
        cc = null;
        JUnitUtil.tearDown();
   }

}
