// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.operations.trains.schedules;

import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.Assume;

import jmri.jmrit.operations.OperationsTestCase;
import jmri.util.JUnitUtil;
import jmri.util.JmriJFrame;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class TrainsScheduleEditActionTest extends OperationsTestCase {

    @Test
    public void testCTor() {
        TrainsScheduleEditAction t = new TrainsScheduleEditAction();
        Assert.assertNotNull("exists", t);
    }
    
    @Test
    public void testAction() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        TrainsScheduleEditAction a = new TrainsScheduleEditAction();
        Assert.assertNotNull("exists", a);
        
        a.actionPerformed(new ActionEvent(this, 0, null));
        
        JmriJFrame f = JmriJFrame.getFrame(Bundle.getMessage("MenuItemEditSchedule"));
        Assert.assertNotNull("exists", f);
        JUnitUtil.dispose(f);
    }

    // private final static Logger log = LoggerFactory.getLogger(TrainsScheduleEditActionTest.class);

}
