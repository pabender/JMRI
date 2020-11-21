// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.ecos;

/**
 * Defines the interface for listening to traffic on the ECoS communications
 * link.
 *
 * @author Bob Jacobsen Copyright (C) 2001
 */
public interface EcosListener extends jmri.jmrix.AbstractMRListener {

    public void message(EcosMessage m);

    public void reply(EcosReply m);

}
