// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrix.rps.swing;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import jmri.jmrix.rps.RpsSystemConnectionMemo;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class CsvExportActionTest {

    private RpsSystemConnectionMemo memo = null;

    @Test
    public void testCTor() {
        CsvExportAction t = new CsvExportAction(memo);
        Assert.assertNotNull("exists",t);
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        memo = new RpsSystemConnectionMemo();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(CsvExportActionTest.class);

}
