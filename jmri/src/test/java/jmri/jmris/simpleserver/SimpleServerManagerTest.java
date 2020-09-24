// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmris.simpleserver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the jmri.jmris.simpleserver.SimpleServerManager class 
 *
 * @author Paul Bender
 */
public class SimpleServerManagerTest {

    @Test
    public void testGetPreferences(){
        SimpleServerManager a = new SimpleServerManager();
        assertThat(a.getPreferences()).withFailMessage("preferences not created").isNotNull();
    }

    @BeforeEach
    public void setUp() {
        jmri.util.JUnitUtil.setUp();
        jmri.util.JUnitUtil.resetProfileManager();
    }

    @AfterEach
    public void tearDown() {
        jmri.util.JUnitUtil.tearDown();

    }

}
