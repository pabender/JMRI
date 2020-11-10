// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.sproggen5;

import jmri.util.JUnitUtil;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration Tests for SprogGen5ConnectionTypeList
 *
 * @author Paul Bender Copyright (C) 2020
 * @author Steve Young Copyright (C) 2019
 */
class SprogGen5ConnectionTypeListTest {

    @BeforeEach
    void setUp() {
        JUnitUtil.setUpLoggingAndCommonProperties();
    }

    @AfterEach
    void tearDown() {
        JUnitUtil.tearDown();
    }

    @Test
    void getManufacturers() {
        assertThat(new SprogGen5ConnectionTypeList().getManufacturers()).contains("SPROG DCC Generation 5");
    }

}