// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.tams.swing;

import jmri.jmrix.tams.TamsSystemConnectionMemo;

/**
 * JPanel interface to handle providing system connection information to a
 * panel.
 *
 * Based on work by Bob Jacobsen
 *
 * @author Kevin Dickerson Copyright (C) 2012
 */
public interface TamsPanelInterface {

    /**
     * 2nd stage of initialization, invoked after the constructor is complete.
     * <p>
     * This needs to be connected to the initContext() method in implementing
     * classes.
     * @param memo system Connection.
     */
    public void initComponents(TamsSystemConnectionMemo memo);

}
