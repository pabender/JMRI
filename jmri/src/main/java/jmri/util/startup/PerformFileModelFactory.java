// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.util.startup;


import javax.swing.JFileChooser;

import jmri.util.xml.XmlFile;

import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Randall Wood 2016
 */
@ServiceProvider(service = StartupModelFactory.class)
public class PerformFileModelFactory extends AbstractFileModelFactory {

    @Override
    public Class<? extends StartupModel> getModelClass() {
        return PerformFileModel.class;
    }

    @Override
    public PerformFileModel newModel() {
        return new PerformFileModel();
    }

    @Override
    protected JFileChooser setFileChooser() {
        return XmlFile.userFileChooser("XML files", "xml");
    }

}
