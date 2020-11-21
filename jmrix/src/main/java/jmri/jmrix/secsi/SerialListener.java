// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.secsi;

/**
 * Listener interface to be notified about serial traffic
 *
 * @author Bob Jacobsen Copyright (C) 2001, 2006, 2007, 2008
 */
public interface SerialListener extends jmri.jmrix.AbstractMRListener {

    public void message(SerialMessage m);

    public void reply(SerialReply m);
}


