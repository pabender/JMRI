// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.tams;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

/**
 * TamsTrafficControllerTest.java
 *
 * Test for the jmri.jmrix.tams.TamsTrafficController
 * class
 *
 * @author Bob Jacobsen
 */
public class TamsTrafficControllerTest extends jmri.jmrix.AbstractMRTrafficControllerTest {

    @Override
    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        tc = new TamsTrafficController();
    }

    @Override
    @AfterEach
    public void tearDown() {
        JUnitUtil.clearShutDownManager(); // put in place because AbstractMRTrafficController implementing subclass was not terminated properly
        JUnitUtil.tearDown();
    }

}
