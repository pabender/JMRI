// SPDX-License-Identifier: GPL-2.0+
package jmri.implementation;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;
import org.junit.Assert;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class SensorGroupConditionalTest {

    @Test
    public void testCTor() {
        SensorGroupConditional t = new SensorGroupConditional("testSystem","testUser");
        Assert.assertNotNull("exists",t);
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(SensorGroupConditionalTest.class);

}
