// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.sprog.sprognano;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Tests for SprogNanoSerialDriverAdapter.
 *
 * @author Paul Bender Copyright (C) 2016
 */
public class SprogNanoSerialDriverAdapterTest {

   @Test
   public void ConstructorTest(){
       SprogNanoSerialDriverAdapter a = new SprogNanoSerialDriverAdapter();
       Assert.assertNotNull(a);

       // clean up
       a.getSystemConnectionMemo().dispose();
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
