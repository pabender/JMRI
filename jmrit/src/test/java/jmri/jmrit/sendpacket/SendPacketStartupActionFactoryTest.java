// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.sendpacket;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test simple functioning of SendPacketStartupActionFactory
 *
 * @author Paul Bender Copyright (C) 2020
 */
class SendPacketStartupActionFactoryTest {

    @Test
    void getActionClasses() {
        SendPacketStartupActionFactory factory = new SendPacketStartupActionFactory();
        assertThat(factory.getActionClasses()).contains(SendPacketAction.class);
    }

}