// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.operations.setup;

import jmri.jmrit.operations.OperationsTestCase;
import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class SetupTest extends OperationsTestCase {

    @Test
    public void testCTor() {
        Setup t = new Setup();
        Assert.assertNotNull("exists",t);
    }

    // private final static Logger log = LoggerFactory.getLogger(SetupTest.class);

}
