// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.operations.locations;

import jmri.jmrit.operations.OperationsTestCase;
import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class YardmasterByTrackPanelTest extends OperationsTestCase {

    @Test
    public void testCTor() {
        YardmasterByTrackPanel t = new YardmasterByTrackPanel();
        Assert.assertNotNull("exists", t);
    }

    // private final static Logger log = LoggerFactory.getLogger(YardmasterByTrackPanelTest.class);

}
