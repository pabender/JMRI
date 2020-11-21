// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.qsi;


/**
 * Stands in for the QsiTrafficController class
 *
 * @author Bob Jacobsen
 */
class QsiListenerScaffold implements QsiListener {

    public QsiListenerScaffold() {
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
