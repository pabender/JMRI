// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.easydcc;

/**
 * Stands in for the EasyDccTrafficController class
 *
 * @author Bob Jacobsen
 */
class EasyDccListenerScaffold implements EasyDccListener {

    public EasyDccListenerScaffold() {
        rcvdReply = null;
        rcvdMsg = null;
    }

    @Override
    public void message(EasyDccMessage m) {
        rcvdMsg = m;
    }

    @Override
    public void reply(EasyDccReply r) {
        rcvdReply = r;
    }

    EasyDccReply rcvdReply;
    EasyDccMessage rcvdMsg;

}
