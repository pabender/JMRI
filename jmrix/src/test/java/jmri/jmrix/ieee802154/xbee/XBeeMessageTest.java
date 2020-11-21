// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.ieee802154.xbee;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * XBeeMessageTest.java
 * <p>
 * Test for the jmri.jmrix.ieee802154.xbee.XBeeMessage class
 *
 * @author Paul Bender
 */
public class XBeeMessageTest extends jmri.jmrix.AbstractMessageTestBase {

    @Override
    @Test
    public void testCtor() {
        Assert.assertEquals("length", 3, m.getNumDataElements());
    }

    @Override
    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        m = new XBeeMessage(3);
    }

    @AfterEach
    public void tearDown() {
        m = null;
        JUnitUtil.tearDown();
    }

}
