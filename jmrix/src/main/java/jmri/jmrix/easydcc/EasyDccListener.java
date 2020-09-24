// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.easydcc;

/**
 * Defines the interface for listening to traffic on the EasyDcc communications
 * link.
 *
 * @author Bob Jacobsen Copyright (C) 2001, 2004
 */
public interface EasyDccListener extends jmri.jmrix.AbstractMRListener {

    public void message(EasyDccMessage m);

    public void reply(EasyDccReply m);

}
