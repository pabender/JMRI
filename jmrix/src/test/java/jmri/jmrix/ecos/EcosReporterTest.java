// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.ecos;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class EcosReporterTest extends jmri.implementation.AbstractRailComReporterTest {

    @BeforeEach
    @Override
    public void setUp() {
        JUnitUtil.setUp();
        r = new EcosReporter("UR1","Test");
    }

    @AfterEach
    @Override
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(EcosReporterTest.class);

}
