// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.operations.trains.tools;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Export data for the Timetable app to a CSV file
 *
 * @author Dan Boudreau Copyright (C) 2018
 * 
 */
public class ExportTimetableAction extends AbstractAction {

    public ExportTimetableAction() {
        super(Bundle.getMessage("MenuItemExportTimetable"));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ExportTimetable ex = new ExportTimetable();
        ex.writeOperationsTimetableFile();
    }
}
