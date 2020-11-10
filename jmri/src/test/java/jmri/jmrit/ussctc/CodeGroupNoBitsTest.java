// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.ussctc;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Tests for Lock class in the jmri.jmrit.ussctc package
 *
 * @author Paul Bender Copyright 2018
 */
public class CodeGroupNoBitsTest {

    @Test
    public void testEnumValues() {
        // this is a pretty poor test, but the class under test is an interface         
        // with an enum that isn't used anywhere in the Java code.
        Assert.assertNotNull(CodeGroupNoBits.None);
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
