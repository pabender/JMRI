// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.mailreport;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class ReportPanelTest {

    @Test
    public void testCTor() {
        ReportPanel t = new ReportPanel();
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

    // private final static Logger log = LoggerFactory.getLogger(ReportPanelTest.class);

}
