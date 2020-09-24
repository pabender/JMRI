// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.rfid;

import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2018
 */
public class RfidStreamConnectionConfigTest extends jmri.jmrix.AbstractConnectionConfigTestBase {

    @BeforeEach
    @Override
    public void setUp() {
        jmri.util.JUnitUtil.setUp();
        cc = new RfidStreamConnectionConfig();
    }

    @AfterEach
    @Override
    public void tearDown() {
        cc = null;
        jmri.util.JUnitUtil.tearDown();
    }

}
