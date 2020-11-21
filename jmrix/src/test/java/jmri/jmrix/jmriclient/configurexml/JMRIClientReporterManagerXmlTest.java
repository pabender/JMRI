// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.jmriclient.configurexml;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * JMRIClientReporterManagerXmlTest.java
 *
 * Test for the JMRIClientReporterManagerXml class
 *
 * @author   Paul Bender  Copyright (C) 2016
 */
public class JMRIClientReporterManagerXmlTest {

    @Test
    public void testCtor(){
      Assert.assertNotNull("JMRIClientReporterManagerXml constructor",new JMRIClientReporterManagerXml());
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

