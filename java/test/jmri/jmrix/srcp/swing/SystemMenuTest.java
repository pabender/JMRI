// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrix.srcp.swing;

import jmri.jmrix.srcp.SRCPListener;
import jmri.jmrix.srcp.SRCPMessage;
import jmri.jmrix.srcp.SRCPSystemConnectionMemo;
import jmri.jmrix.srcp.SRCPTrafficController;
import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;


/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class SystemMenuTest {
        
    private SRCPSystemConnectionMemo m = null;

    @Test
    public void testCTor() {
        SystemMenu t = new SystemMenu(m);
        Assert.assertNotNull("exists",t);
    }

    @Test
    public void testStringCTor() {
        SystemMenu t = new SystemMenu("TestMemo",m);
        Assert.assertNotNull("exists",t);
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        SRCPTrafficController et = new SRCPTrafficController() {
            @Override
            public void sendSRCPMessage(SRCPMessage m, SRCPListener l) {
                // we aren't actually sending anything to a layout.
            }
        };
        m = new SRCPSystemConnectionMemo(et);
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.clearShutDownManager(); // put in place because AbstractMRTrafficController implementing subclass was not terminated properly
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(SystemMenuTest.class);

}
