// SPDX-License-Identifier: GPL-2.0+
package jmri.swing;

public interface PreferencesSubPanel extends PreferencesPanel {

    public abstract String getParentClassName();

    public abstract void setParent(PreferencesPanel parent);

    public abstract PreferencesPanel getParent();
}
