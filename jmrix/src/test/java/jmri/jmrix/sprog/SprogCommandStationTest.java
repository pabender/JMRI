// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.sprog;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Tests for SprogCommandStation.
 *
 * @author Paul Bender Copyright (C) 2016
 */
public class SprogCommandStationTest {

   @Test
   public void ConstructorTest(){
       SprogSystemConnectionMemo m = new SprogSystemConnectionMemo();
       SprogTrafficController tc = new SprogTrafficControlScaffold(m);
       SprogCommandStation cs = new SprogCommandStation(tc);
       Assert.assertNotNull(cs);
       tc.dispose();
   }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

}
