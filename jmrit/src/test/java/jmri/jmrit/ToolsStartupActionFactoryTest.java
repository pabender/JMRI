// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit;

import jmri.util.xml.XmlFileValidateAction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test simple functioning of ToolsStartupActionFactory
 *
 * @author Paul Bender Copyright (C) 2020
 */
class ToolsStartupActionFactoryTest {

    @Test
    void getActionClasses() {
        ToolsStartupActionFactory factory = new ToolsStartupActionFactory();
        assertThat(factory.getActionClasses()).contains(MemoryFrameAction.class).contains(XmlFileValidateAction.class);
    }

}