// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrix.sprog.update;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class SprogVersionTest {

    @Test
    public void testCTor() {
        SprogType t = new SprogType(SprogType.UNKNOWN);
        SprogVersion v = new SprogVersion(t);
        Assert.assertNotNull("exists",v);
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(SprogVersionTest.class);

}
