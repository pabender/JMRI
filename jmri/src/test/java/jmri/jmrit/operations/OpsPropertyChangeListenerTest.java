// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.operations;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class OpsPropertyChangeListenerTest extends OperationsTestCase {

    @Test
    public void testCTor() {
        OpsPropertyChangeListener t = new OpsPropertyChangeListener();
        Assert.assertNotNull("exists",t);
    }

    // private final static Logger log = LoggerFactory.getLogger(OpsPropertyChangeListenerTest.class);

}
