// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.sprog;

import org.junit.jupiter.api.*;

/**
 * @author Paul Bender Copyright (C) 2018
 */
public class SprogCSStreamConnectionConfigTest extends jmri.jmrix.AbstractConnectionConfigTestBase {

    @BeforeEach
    @Override
    public void setUp() {
        jmri.util.JUnitUtil.setUp();
        cc = new SprogCSStreamConnectionConfig();
    }

    @AfterEach
    @Override
    public void tearDown() {
        jmri.util.JUnitUtil.tearDown();
    }

}
