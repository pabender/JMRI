// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package apps;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;
import org.junit.Assert;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class LicenseActionTest {

    @Test
    public void testCTor() {
        LicenseAction t = new LicenseAction();
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

    // private final static Logger log = LoggerFactory.getLogger(LicenseActionTest.class);

}
