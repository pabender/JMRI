// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrix.powerline.insteon2412s;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class ConstantsTest {

    @Test
    public void testCTor() {
        Constants t = new Constants();
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

    // private final static Logger log = LoggerFactory.getLogger(ConstantsTest.class);

}
