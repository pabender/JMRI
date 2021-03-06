// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.dccpp.serial;

import jmri.util.SystemType;

/**
 * Handle configuring a DCC++ layout connection via a Serial adaptor.
 * <p>
 * This uses the {@link DCCppAdapter} class to do the actual connection.
 *
 * @author Mark Underwood Copyright (C) 2015
 *
 * @see DCCppAdapter
 *
 * Based on jmri.jmrix.lenz.liusb.ConnectionConfig by Paul Bender
 */
public class ConnectionConfig extends jmri.jmrix.dccpp.AbstractDCCppSerialConnectionConfig {

    /**
     * Ctor for an object being created during load process; Swing init is
     * deferred.
     * @param p serial port adapter.
     */
    public ConnectionConfig(jmri.jmrix.SerialPortAdapter p) {
        super(p);
    }

    /**
     * Ctor for a connection configuration with no preexisting adapter.
     * {@link #setInstance()} will fill the adapter member.
     */
    public ConnectionConfig() {
        super();
    }

    @Override
    public String name() {
        return "DCC++ Serial Port";
    }

    @Override
    protected String[] getPortFriendlyNames() {
        if (SystemType.isWindows()) {
            return new String[]{"DCC++ Serial Port", "DCC++_Serial"};
        }
        return new String[]{};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setInstance() {
        if (adapter == null) {
            adapter = new DCCppAdapter();
        }
    }

}
