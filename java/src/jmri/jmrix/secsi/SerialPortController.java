// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrix.secsi;

import jmri.SystemConnectionMemo;

/**
 * Abstract base for classes representing a communications port
 *
 * @author Bob Jacobsen Copyright (C) 2001, 2006, 2007, 2008
 */
public abstract class SerialPortController extends jmri.jmrix.AbstractSerialPortController {

    // base class. Implementations will provide InputStream and OutputStream
    // objects to SerialTrafficController classes, who in turn will deal in messages.
    protected SerialPortController(SystemConnectionMemo connectionMemo) {
        super(connectionMemo);
    }

}
