// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.rfid.generic.standalone;

import jmri.jmrix.rfid.RfidSystemConnectionMemo;
import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class StandaloneReplyTest extends jmri.jmrix.AbstractMessageTestBase {

    private StandaloneTrafficController tc = null;

    @BeforeEach
    @Override
    public void setUp() {
        JUnitUtil.setUp();
        RfidSystemConnectionMemo memo = new RfidSystemConnectionMemo();
        memo.setProtocol(new jmri.jmrix.rfid.protocol.coreid.CoreIdRfidProtocol());
        tc = new StandaloneTrafficController(memo);
        m = new StandaloneReply(tc);
    }

    @AfterEach
    public void tearDown() {
        m = null;
        tc.terminateThreads();
        tc = null;
        JUnitUtil.tearDown();

    }

    // private final static Logger log = LoggerFactory.getLogger(StandaloneReplyTest.class);
}
