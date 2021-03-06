// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.internal.configurexml;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * InternalTurnoutManagerXmlTest.java
 *
 * Test for the InternalTurnoutManagerXml class
 *
 * @author   Paul Bender  Copyright (C) 2016
 */
public class InternalTurnoutManagerXmlTest {

    @Test
    public void testCtor(){
      Assert.assertNotNull("InternalTurnoutManagerXml constructor",new InternalTurnoutManagerXml());
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

