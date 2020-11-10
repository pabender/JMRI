// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.openlcb;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;
import org.junit.Assert;

/**
 * OlcbProgrammerManagerTest.java
 *
 * Test for the jmri.jmrix.openlcb.OlcbProgrammerManager class
 *
 * @author Bob Jacobsen
 */
public class OlcbProgrammerManagerTest {

    @Test
    public void testCtor() {
        new OlcbSystemConnectionMemo();
        OlcbProgrammerManager s = new OlcbProgrammerManager(new OlcbProgrammer());
        Assert.assertNotNull(s);
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
