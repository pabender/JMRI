// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrix.loconet.locormi;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class LnMessageClientActionTest {

    @Test
    public void testCTor() {
        LnMessageClientAction t = new LnMessageClientAction("test");
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

    // private final static Logger log = LoggerFactory.getLogger(LnMessageClientActionTest.class);

}
