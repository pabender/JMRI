// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.operations.locations.schedules;

import jmri.jmrit.operations.OperationsTestCase;
import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class ScheduleTableModelTest extends OperationsTestCase {

    @Test
    public void testCTor() {
        ScheduleTableModel t = new ScheduleTableModel();
        Assert.assertNotNull("exists",t);
    }

    // private final static Logger log = LoggerFactory.getLogger(ScheduleTableModelTest.class);

}
