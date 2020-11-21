// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.can;

/**
 * Traffic controller for CAN access.
 *
 * @author Bob Jacobsen Copyright (C) 2008
 */
abstract public class TrafficController extends AbstractCanTrafficController {

    /**
     * Create a new CAN TrafficController instance.
     */
    public TrafficController() {
        super();
    }

    protected int _canid = 120;

    /**
     * Get the Connection CAN ID.
     * @return Connection CAN ID, defaults to 120
     */
    public int getCanid() {
        return _canid;
    }
    
    /**
     * Set the Connection CAN ID.
     * @param canid CAN ID to use
     */
    public void setCanId(int canid) {
        _canid = canid;
    }

}
