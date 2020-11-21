// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.whereused;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Tests for the MemoryWhereUsed Class
 *
 * @author Dave Sand Copyright (C) 2020
 */
public class MemoryWhereUsedTest {

    @Test
    public void testMemoryWhereUsed() {
        MemoryWhereUsed ctor = new MemoryWhereUsed();
        Assert.assertNotNull("exists", ctor);
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }
}
