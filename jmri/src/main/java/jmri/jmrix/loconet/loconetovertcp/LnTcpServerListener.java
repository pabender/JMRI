// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.loconet.loconetovertcp;

/**
 * Implementation of the LocoNetOverTcp LbServer Server Protocol.
 *
 * @author Alex Shepherd Copyright (C) 2006
 */
public interface LnTcpServerListener {

    public void notifyServerStateChanged(LnTcpServer s);

    public void notifyClientStateChanged(LnTcpServer s);

}
