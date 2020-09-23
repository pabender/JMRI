// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.managers;

import jmri.jmrix.debugthrottle.DebugThrottleManager;
import jmri.jmrix.debugthrottle.DebugThrottle;
import jmri.DccLocoAddress;
import jmri.ThrottleListener;
import jmri.LocoAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is an extension of the DebugThrottleManager that always requires
 * the calling throttle object to share to get a valid throttle.
 * <P>
 * @author Bob Jacobsen Copyright (C) 2003, 2005
 * @author Bob Jacobsen Copyright (C) 2018
 */
public class StealingOrSharingThrottleManager extends DebugThrottleManager {

    public StealingOrSharingThrottleManager() {
        super();
    }

    /**
     * Constructor.
     */
    public StealingOrSharingThrottleManager(jmri.SystemConnectionMemo memo) {
        super(memo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void requestThrottleSetup(LocoAddress a, boolean control) {
        // Immediately trigger the steal or share callback.
        notifyDecisionRequest(a,ThrottleListener.DecisionType.STEAL_OR_SHARE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void responseThrottleDecision(LocoAddress address, ThrottleListener l, ThrottleListener.DecisionType decision){
        if ( decision == ThrottleListener.DecisionType.STEAL ) {
            log.error("1: Got a steal decision");
            DccLocoAddress a = (DccLocoAddress) address;
            notifyThrottleKnown(new DebugThrottle(a, adapterMemo), address);
        }
        else if ( decision == ThrottleListener.DecisionType.SHARE ) {
            log.error("1: Got a share decision");
            DccLocoAddress a = (DccLocoAddress) address;
            notifyThrottleKnown(new DebugThrottle(a, adapterMemo), address);
        }
        else {
            cancelThrottleRequest(address,l);
            failedThrottleRequest(address,"user declined to steal or share");
        }
    }
    private final static Logger log = LoggerFactory.getLogger(StealingOrSharingThrottleManager.class);
}
