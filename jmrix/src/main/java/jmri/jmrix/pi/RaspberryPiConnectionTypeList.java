// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.pi;

import jmri.jmrix.ConnectionTypeList;
import org.openide.util.lookup.ServiceProvider;

/**
 * Returns a list of valid Raspberry Pi Connection Types
 *
 * @author Paul Bender Copyright (C) 2015
  *
 */
@ServiceProvider(service = ConnectionTypeList.class)
public class RaspberryPiConnectionTypeList implements jmri.jmrix.ConnectionTypeList {

    public static final String PI = "Raspberry Pi Foundation";

    @Override
    public String[] getAvailableProtocolClasses() {
        return new String[]{
            "jmri.jmrix.pi.RaspberryPiConnectionConfig"
        };
    }

    @Override
    public String[] getManufacturers() {
        return new String[]{PI};
    }

}
