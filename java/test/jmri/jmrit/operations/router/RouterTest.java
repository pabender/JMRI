// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.operations.router;

import jmri.jmrit.operations.OperationsTestCase;
import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class RouterTest extends OperationsTestCase {

    @Test
    public void testCTor() {
        Router t = new Router();
        Assert.assertNotNull("exists",t);
    }

    // private final static Logger log = LoggerFactory.getLogger(RouterTest.class);

}
