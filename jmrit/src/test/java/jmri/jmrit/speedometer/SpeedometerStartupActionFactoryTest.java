// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.speedometer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test simple functioning of SpeedometerStartupActionFactory
 *
 * @author Paul Bender Copyright (C) 2020
 */
class SpeedometerStartupActionFactoryTest {

    @Test
    void getActionClasses() {
        SpeedometerStartupActionFactory factory = new SpeedometerStartupActionFactory();
        assertThat(factory.getActionClasses()).contains(SpeedometerAction.class);
    }

}