// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.operations.setup;

import jmri.jmrit.operations.OperationsTestCase;
import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class ControlTest extends OperationsTestCase {

    @Test
    public void testCTor() {
        Control t = new Control();
        Assert.assertNotNull("exists",t);
    }

    // private final static Logger log = LoggerFactory.getLogger(ControlTest.class);

}
