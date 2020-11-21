// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.roco.z21;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

/**
 * Tests for the jmri.jmrix.roco.z21.z21TrafficController class
 *
 * @author Paul Bender
 */
public class Z21TrafficControllerTest extends jmri.jmrix.AbstractMRTrafficControllerTest {

    @Override
    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        tc = new Z21TrafficController();
    }

    @Override
    @AfterEach
    public void tearDown() {
        tc.terminateThreads();
        tc = null;
        JUnitUtil.tearDown();
    }

}
