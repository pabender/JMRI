// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.operations.trains.tools;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import jmri.jmrit.operations.trains.Train;

/**
 * Swing action to create and register a TrainSetColorFrame object.
 *
 * @author Bob Jacobsen Copyright (C) 2001
 * @author Daniel Boudreau Copyright (C) 2014
 */
public class TrainsTableSetColorAction extends AbstractAction {

    public TrainsTableSetColorAction() {
        super(Bundle.getMessage("MenuItemSetTrainColor"));
    }

    Train _train = null;

    public TrainsTableSetColorAction(Train train) {
        this();
        _train = train;
    }

    TrainsTableSetColorFrame f = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (f == null || !f.isVisible()) {
            f = new TrainsTableSetColorFrame(_train);
        }
        f.setExtendedState(Frame.NORMAL);
        f.setVisible(true); // this also brings the frame into focus
    }
}


