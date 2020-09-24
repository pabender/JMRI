// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.sprog.pi.pisprognano;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Tests for PiSprogNanoSerialDriverAdapter.
 *
 * @author Paul Bender Copyright (C) 2016
 */
public class PiSprogNanoSerialDriverAdapterTest {

   @Test
   public void ConstructorTest(){
       PiSprogNanoSerialDriverAdapter a = new PiSprogNanoSerialDriverAdapter();
       Assert.assertNotNull(a);
 
       // clean up
       a.getSystemConnectionMemo().getSprogTrafficController().dispose();
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
