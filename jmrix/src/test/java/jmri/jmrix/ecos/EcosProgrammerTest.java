// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.ecos;

import jmri.ProgrammingMode;
import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class EcosProgrammerTest extends jmri.jmrix.AbstractProgrammerTest {

    @Test
    @Override
    public void testDefault() {
        Assert.assertEquals("Check Default", ProgrammingMode.DIRECTBYTEMODE,
                programmer.getMode());        
    }

    @Override
    @Test
    public void testDefaultViaBestMode() {
        Assert.assertEquals("Check Default", ProgrammingMode.DIRECTBYTEMODE,
                ((EcosProgrammer)programmer).getBestMode());        
    }

    @Override
    @Test
    public void testSetGetMode() {
        Assert.assertThrows(IllegalArgumentException.class, () -> programmer.setMode(ProgrammingMode.REGISTERMODE));
    }

    @BeforeEach
    @Override
    public void setUp() {
        JUnitUtil.setUp();
        EcosTrafficController tc = new EcosInterfaceScaffold();
        programmer = new EcosProgrammer(tc);
    }

    @AfterEach
    @Override
    public void tearDown() {
        programmer = null;
        JUnitUtil.clearShutDownManager(); // put in place because AbstractMRTrafficController implementing subclass was not terminated properly
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(EcosProgrammerTest.class);

}
