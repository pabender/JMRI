// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.operations.locations.tools;

import jmri.jmrit.operations.OperationsTestCase;
import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class EditCarTypeActionTest extends OperationsTestCase {

    @Test
    public void testCTor() {
        EditCarTypeAction t = new EditCarTypeAction();
        Assert.assertNotNull("exists",t);
    }

    // private final static Logger log = LoggerFactory.getLogger(EditCarTypeActionTest.class);

}
