// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.ieee802154.xbee;

/**
 * Listener interface to be notified about XBee traffic
 *
 * @author Bob Jacobsen Copyright (C) 2001, 2006, 2007, 2008
 */
public interface XBeeListener extends jmri.jmrix.AbstractMRListener {

    public void message(XBeeMessage m);

    public void reply(XBeeReply m);
}


