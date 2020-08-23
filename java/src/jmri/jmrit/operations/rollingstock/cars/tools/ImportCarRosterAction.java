// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.operations.rollingstock.cars.tools;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Starts the ImportCars thread
 *
 * @author Dan Boudreau Copyright (C) 2008
 */
public class ImportCarRosterAction extends AbstractAction {

    public ImportCarRosterAction() {
        super(Bundle.getMessage("MenuItemImport"));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Thread mb = new ImportCars();
        mb.setName("Import Cars"); // NOI18N
        mb.start();
    }

//    private final static Logger log = LoggerFactory.getLogger(ImportCarRosterAction.class);
}
