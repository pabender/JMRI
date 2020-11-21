// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.mrc;

import jmri.JmriException;

/**
 * MRC-specific exception
 *
 * @author Bob Jacobsen Copyright (C) 2001
 */
public class MrcException extends JmriException {

    public MrcException(String m) {
        super(m);
    }

}
