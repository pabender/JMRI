// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrix.loconet.usb_dcs52;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class UsbDcs52AdapterTest {

    @Test
    public void testCTor() {
        UsbDcs52Adapter t = new UsbDcs52Adapter();
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

    // private final static Logger log = LoggerFactory.getLogger(UsbDcs52AdapterTest.class);

}
