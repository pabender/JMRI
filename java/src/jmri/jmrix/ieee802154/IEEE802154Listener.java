package jmri.jmrix.ieee802154;

/**
 * Listener interface to be notified about serial traffic
 *
 * @author Bob Jacobsen Copyright (C) 2001, 2006, 2007, 2008
 */
public interface IEEE802154Listener extends jmri.jmrix.AbstractMRListener {

    void message(IEEE802154Message m);

    void reply(IEEE802154Reply m);

}
