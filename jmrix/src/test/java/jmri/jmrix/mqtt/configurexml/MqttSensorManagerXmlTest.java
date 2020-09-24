// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.mqtt.configurexml;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Test for the MqttSensorManagerXml class
 *
 * @author Bob Jacobsen  Copyright (C) 2020
 */
public class MqttSensorManagerXmlTest {

    @Test
    public void testCtor(){
      Assert.assertNotNull("NceSensorManagerXml constructor",new MqttSensorManagerXml());
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

