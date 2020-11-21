// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.symbolicprog.tabbedframe;

import javax.swing.JComponent;
import jmri.symbolicprog.ArithmeticQualifier;
import jmri.symbolicprog.VariableValue;

/**
 * Qualify a JComponent on a numerical test by setting the JComponent's
 * visibility
 *
 * @author Bob Jacobsen Copyright (C) 2010, 2014
  *
 */
public class JComponentQualifier extends ArithmeticQualifier {

    JComponent component;

    public JComponentQualifier(JComponent component, VariableValue watchedVal, int value, String relation) {
        super(watchedVal, value, relation);

        this.component = component;

        setWatchedAvailable(currentDesiredState());
    }

    @Override
    public void setWatchedAvailable(boolean enable) {
        component.setVisible(enable);
    }

    @Override
    protected boolean currentAvailableState() {
        return component.isVisible();
    }

}
