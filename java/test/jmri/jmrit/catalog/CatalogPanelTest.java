// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.catalog;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;
import org.junit.Assert;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class CatalogPanelTest {

    @Test
    public void testCTor() {
        CatalogPanel t = CatalogPanel.makeDefaultCatalog();
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

    // private final static Logger log = LoggerFactory.getLogger(CatalogPanelTest.class);

}
