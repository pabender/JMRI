// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.jmriclient;

/**
 * Defines the interface for listening to traffic on the JMRIClient
 * communications link.
 *
 * @author Bob Jacobsen Copyright (C) 2001, 2004, 2008
 */
public interface JMRIClientListener extends jmri.jmrix.AbstractMRListener {

    public void message(JMRIClientMessage m);

    public void reply(JMRIClientReply m);

}
