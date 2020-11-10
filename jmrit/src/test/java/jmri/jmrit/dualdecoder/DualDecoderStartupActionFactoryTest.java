// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.dualdecoder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test simple functioning of DualDecoderStartupActionFactory
 *
 * @author Paul Bender Copyright (C) 2020
 */
class DualDecoderStartupActionFactoryTest {

    @Test
    void getActionClasses() {
        DualDecoderStartupActionFactory factory = new DualDecoderStartupActionFactory();
        assertThat(factory.getActionClasses()).contains(DualDecoderToolAction.class);
    }

}