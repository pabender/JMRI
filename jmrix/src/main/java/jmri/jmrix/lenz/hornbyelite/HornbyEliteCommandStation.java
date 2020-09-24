// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.lenz.hornbyelite;

/**
 * Defines the routines that differentiate a Hornby Elite Command Station from a
 * Lenz command station.
 *
 * @author Paul Bender Copyright (C) 2008
 */
public class HornbyEliteCommandStation extends jmri.jmrix.lenz.LenzCommandStation {

    /**
     * The Hornby Elite does support Ops Mode programming.
     */
    @Override
    public boolean isOpsModePossible() {
        return true;
    }

}
