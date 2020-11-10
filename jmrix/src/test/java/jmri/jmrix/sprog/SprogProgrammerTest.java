// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.sprog;

import jmri.ProgrammingMode;
import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Tests for SprogProgrammer.
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class SprogProgrammerTest extends jmri.jmrix.AbstractProgrammerTest {

    private SprogTrafficControlScaffold stcs = null;
    private SprogSystemConnectionMemo m = null; 

    @Test
    @Override
    public void testDefault() {
        Assert.assertEquals("Check Default", ProgrammingMode.DIRECTBITMODE,
                programmer.getMode());        
    }
    
    @Override
    @Test
    public void testDefaultViaBestMode() {
        Assert.assertEquals("Check Default", ProgrammingMode.DIRECTBITMODE,
                ((SprogProgrammer)programmer).getBestMode());        
    }

    @Test
    @Override
    public void testSetGetMode() {
        Assert.assertThrows(IllegalArgumentException.class, () -> programmer.setMode(ProgrammingMode.REGISTERMODE));        
    }

    @BeforeEach
    @Override
    public void setUp() {
        jmri.util.JUnitUtil.setUp();
        // prepare an interface
        jmri.util.JUnitUtil.resetInstanceManager();

        m = new SprogSystemConnectionMemo(jmri.jmrix.sprog.SprogConstants.SprogMode.SERVICE);
        stcs = new SprogTrafficControlScaffold(m);
        m.setSprogTrafficController(stcs);
        m.configureManagers();
        programmer = new SprogProgrammer(m);
    }

    @AfterEach
    @Override
    public void tearDown() {
        m.dispose();
        stcs.dispose();
        m = null;
        stcs = null;
        programmer = null;
        JUnitUtil.tearDown();
    }

}
