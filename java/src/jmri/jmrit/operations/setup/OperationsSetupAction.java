// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.operations.setup;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Swing action to create and register a OperationsSetupFrame object.
 *
 * @author Bob Jacobsen Copyright (C) 2001
 * @author Daniel Boudreau Copyright (C) 2008
 */
public class OperationsSetupAction extends AbstractAction {

    public OperationsSetupAction() {
        super(Bundle.getMessage("MenuSetup")); // NOI18N
    }

    static OperationsSetupFrame operationsSetupFrame = null;

    @Override
    @SuppressFBWarnings(value = "ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD", justification = "Only one OperationsSetupFrame")
    public void actionPerformed(ActionEvent e) {
        // create a settings frame
        if (operationsSetupFrame == null || !operationsSetupFrame.isVisible()) {
            operationsSetupFrame = new OperationsSetupFrame();
            operationsSetupFrame.initComponents();
        }
        operationsSetupFrame.setExtendedState(Frame.NORMAL);
        operationsSetupFrame.setVisible(true); // this also brings the frame into focus
    }
}


