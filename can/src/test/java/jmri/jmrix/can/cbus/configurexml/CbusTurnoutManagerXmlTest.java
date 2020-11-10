// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.can.cbus.configurexml;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * CbusTurnoutManagerXmlTest.java
 *
 * Test for the CbusTurnoutManagerXml class
 *
 * @author   Paul Bender  Copyright (C) 2016
 */
public class CbusTurnoutManagerXmlTest {

    @Test
    public void testCtor(){
      Assert.assertNotNull("CbusTurnoutManagerXml constructor",new CbusTurnoutManagerXml());
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

