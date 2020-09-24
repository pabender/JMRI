// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.marklin.swing;

import jmri.jmrix.marklin.MarklinSystemConnectionMemo;

/**
 * JPanel interface to handle providing system connection information to a
 * panel.
 *
 * @author Kevin Dickerson Copyright 2010
 * @since 2.11.3
 */
public interface MarklinPanelInterface {

    /**
     * 2nd stage of initialization, invoked after the constuctor is complete.
     * <p>
     * This needs to be connected to the initContext() method in implementing
     * classes.
     * @param memo system connection.
     */
    public void initComponents(MarklinSystemConnectionMemo memo);

}
