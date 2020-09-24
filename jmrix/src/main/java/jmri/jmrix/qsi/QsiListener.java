// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.qsi;

/**
 * Defines the interface for listening to traffic on the QSI communications
 * link.
 *
 * @author Bob Jacobsen Copyright (C) 2007
 */
public interface QsiListener extends java.util.EventListener {

    public void message(QsiMessage m);

    public void reply(QsiReply m);

}
