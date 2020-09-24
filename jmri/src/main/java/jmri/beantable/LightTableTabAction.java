// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.beantable;

import jmri.*;

public class LightTableTabAction extends AbstractTableTabAction<Light> {

    public LightTableTabAction(String s) {
        super(s);
    }

    public LightTableTabAction() {
        this("Multiple Tabbed");
    }

    @Override
    protected Manager<Light> getManager() {
        return InstanceManager.lightManagerInstance();
    }

    @Override
    protected String getClassName() {
        return LightTableAction.class.getName();
    }

    @Override
    protected LightTableAction getNewTableAction(String choice) {
        return new LightTableAction(choice);
    }

    @Override
    protected String helpTarget() {
        return "package.jmri.jmrit.beantable.LightTable";
    }
}
