// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.bachrus;

/**
 * Defines the interface for listening to traffic on the NCE communications
 * link.
 *
 * @author Andrew Crosland Copyright (C) 2010
 */
public interface SpeedoListener extends java.util.EventListener {

    public void reply(SpeedoReply m);

}
