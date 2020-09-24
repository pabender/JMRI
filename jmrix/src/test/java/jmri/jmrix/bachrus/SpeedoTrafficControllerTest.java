// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.bachrus;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * SpeedoTrafficControllerTest.java
 *
 * Test for the jmri.jmrix.bachrus.SpeedoTrafficController class
 *
 * @author Paul Bender Copyright (C) 2016
 */
public class SpeedoTrafficControllerTest {

    @Test public void integerConstructorTest() {
        SpeedoSystemConnectionMemo m = new SpeedoSystemConnectionMemo();
        SpeedoTrafficController tc = new SpeedoTrafficController(m);
        Assert.assertNotNull(tc);
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
