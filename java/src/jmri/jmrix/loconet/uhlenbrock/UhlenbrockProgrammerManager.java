// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.loconet.uhlenbrock;

import jmri.jmrix.loconet.LnProgrammerManager;
import jmri.jmrix.loconet.LocoNetSystemConnectionMemo;

/**
 * Extend LnProgrammerManager to disable on-the-track programming, which is not
 * supported by IB-COM or Intellibox II
 *
 * @see jmri.managers.DefaultProgrammerManager
 * @author Lisby Copyright (C) 2014
 * 
 */
public class UhlenbrockProgrammerManager extends LnProgrammerManager {

    public UhlenbrockProgrammerManager(LocoNetSystemConnectionMemo memo) {
        super(memo);
    }

    @Override
    public boolean isAddressedModePossible() {
        return true;
    }
}
