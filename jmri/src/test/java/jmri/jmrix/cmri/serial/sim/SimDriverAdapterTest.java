// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.cmri.serial.sim;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Tests for SimDriverAdapter class.
 *
 * @author Paul Bender Copyright (C) 2016
 **/

public class SimDriverAdapterTest {

   @Test
   public void ConstructorTest(){
      Assert.assertNotNull("SimDriverAdapter constructor", new SimDriverAdapter());
   }

   @BeforeEach
   public void setUp() {
        JUnitUtil.setUp();

        jmri.util.JUnitUtil.initDefaultUserMessagePreferences();
   }

   @AfterEach
   public void tearDown(){
        JUnitUtil.tearDown();
   }

}
