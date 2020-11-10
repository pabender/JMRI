// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.jinput.treecontrol;

import jmri.util.JUnitUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * tests for TreeControlStartupActionFactory.
 *
 * @author Paul Bender Copyright 2020
 */
class TreeControlStartupActionFactoryTest {

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
        TreeControlStartupActionFactory factory = new TreeControlStartupActionFactory();
        assertThat(factory.getActionClasses()).isNotEmpty().contains(TreeAction.class);
    }

}