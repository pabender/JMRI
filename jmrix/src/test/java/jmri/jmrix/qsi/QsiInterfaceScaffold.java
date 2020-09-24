// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
/**
 * QsiInterfaceScaffold.java
 *
 * Stands in for the QsiTrafficController class
 *
 * @author Bob Jacobsen
 */
package jmri.jmrix.qsi;


class QsiInterfaceScaffold implements QsiListener {

    public QsiInterfaceScaffold() {
        rcvdReply = null;
        rcvdMsg = null;
    }

    @Override
    public void message(QsiMessage m) {
        rcvdMsg = m;
    }

    @Override
    public void reply(QsiReply r) {
        rcvdReply = r;
    }

    QsiReply rcvdReply;
    QsiMessage rcvdMsg;

}
