// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrix.ecos.swing.locodatabase;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class EcosLocoTableTabActionTest {

    @Test
    public void testCTor() {
        EcosLocoTableTabAction t = new EcosLocoTableTabAction();
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

    // private final static Logger log = LoggerFactory.getLogger(EcosLocoTableTabActionTest.class);

}
