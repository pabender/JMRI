// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.bachrus.swing;

import jmri.jmrix.bachrus.SpeedoSystemConnectionMemo;
import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class SpeedoComponentFactoryTest {

    @Test
    public void testCTor() {
        SpeedoSystemConnectionMemo m = new SpeedoSystemConnectionMemo();
        SpeedoComponentFactory t = new SpeedoComponentFactory(m);
        Assert.assertNotNull("exists",t);
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(SpeedoComponentFactoryTest.class);

}
