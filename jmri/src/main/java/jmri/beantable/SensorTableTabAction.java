// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.beantable;

import jmri.*;

public class SensorTableTabAction extends AbstractTableTabAction<Sensor> {

    public SensorTableTabAction(String s) {
        super(s);
    }

    public SensorTableTabAction() {
        this("Multiple Tabbed");
    }

    @Override
    protected Manager<Sensor> getManager() {
        return InstanceManager.sensorManagerInstance();
    }

    @Override
    protected String getClassName() {
        return SensorTableAction.class.getName();
    }

    @Override
    protected SensorTableAction getNewTableAction(String choice) {
        return new SensorTableAction(choice);
    }

    @Override
    protected String helpTarget() {
        return "package.jmri.beantable.SensorTable";
    }
}
