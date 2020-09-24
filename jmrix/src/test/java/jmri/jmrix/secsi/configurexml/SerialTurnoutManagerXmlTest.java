// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.secsi.configurexml;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * SerialTurnoutManagerXmlTest.java
 *
 * Test for the SerialTurnoutManagerXml class
 *
 * @author   Paul Bender  Copyright (C) 2016
 */
public class SerialTurnoutManagerXmlTest {

    @Test
    public void testCtor(){
      Assert.assertNotNull("SerialTurnoutManagerXml constructor",new SerialTurnoutManagerXml());
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

