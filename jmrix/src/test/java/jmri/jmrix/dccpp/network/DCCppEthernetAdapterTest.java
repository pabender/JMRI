// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.dccpp.network;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;
import org.junit.Assert;

/**
 * DCCppEthernetAdapterTest.java
 *
 * Test for the jmri.jmrix.dccpp.network.DCCppEthernetAdapter
 * class
 *
 * @author Paul Bender
 * @author Mark Underwood Copyright (C) 2015
 */
public class DCCppEthernetAdapterTest {

    @Test
    public void testCtor() {
        DCCppEthernetAdapter a = new DCCppEthernetAdapter();
        Assert.assertNotNull(a);
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
