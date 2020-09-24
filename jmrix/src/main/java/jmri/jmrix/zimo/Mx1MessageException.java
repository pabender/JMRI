// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.zimo;

import jmri.JmriException;

/**
 * Zimo-specfic exceptions.
 *
 * @author Bob Jacobsen Copyright (C) 2002
 *
 * Adapted by Sip Bosch for use with zimo Mx-1
 */
public class Mx1MessageException extends JmriException {

    public Mx1MessageException(String s) {
        super(s);
    }

    public Mx1MessageException() {
    }
}
