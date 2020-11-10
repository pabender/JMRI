// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.dccpp.dccppovertcp;

import jmri.util.JUnitUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for ServerStartupActionFactory class.
 *
 * @author Paul Bender Copyright (C) 2020
 **/
class ServerStartupActionFactoryTest {

    @BeforeEach
    void setUp() {
        JUnitUtil.setUpLoggingAndCommonProperties();
    }

    @AfterEach
    void tearDown() {
        JUnitUtil.tearDown();
    }

    @Test
    void getActionClasses() {
        ServerStartupActionFactory factory = new ServerStartupActionFactory();
        assertThat(factory.getActionClasses()).isNotEmpty().contains(ServerAction.class);
    }

}
