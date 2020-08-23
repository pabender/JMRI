// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.lenz;

/**
 * Abstract Configuration for an XpressNet Serial Connection
 *
 * @author Paul Bender Copyright (C) 2010
 */
public abstract class AbstractXNetSerialConnectionConfig extends jmri.jmrix.AbstractSerialConnectionConfig {

    /**
     * Ctor for an object being created during load process; Swing init is
     * deferred.
     * @param p serial port adapter.
     */
    public AbstractXNetSerialConnectionConfig(jmri.jmrix.SerialPortAdapter p) {
        super(p);
    }

    /**
     * Ctor for a connection configuration with no preexisting adapter.
     * {@link #setInstance()} will fill the adapter member.
     */
    public AbstractXNetSerialConnectionConfig() {
        super();
    }

}
