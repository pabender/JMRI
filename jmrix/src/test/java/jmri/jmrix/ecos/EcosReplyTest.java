// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.ecos;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class EcosReplyTest extends jmri.jmrix.AbstractMessageTestBase {


    @BeforeEach
    @Override
    public void setUp() {
        JUnitUtil.setUp();
        m = new EcosReply();
    }

    @AfterEach
    public void tearDown() {
        m = null;
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(EcosReplyTest.class);

}
