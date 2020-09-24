// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.lenz;

import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class XNetStreamConnectionConfigTest extends jmri.jmrix.AbstractConnectionConfigTestBase {

    @BeforeEach
    @Override
    public void setUp() {
        jmri.util.JUnitUtil.setUp();
        cc = new XNetStreamConnectionConfig(new XNetStreamPortController());
    }

    @AfterEach
    @Override
    public void tearDown() {
        cc = null;
        jmri.util.JUnitUtil.tearDown();
    }

}
