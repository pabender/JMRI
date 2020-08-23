// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrix;

import jmri.SystemConnectionMemo;

public interface ConfiguringSystemConnectionMemo extends SystemConnectionMemo {

    /**
     * Configure the common managers associated with the System Connection memo.
     */
    void configureManagers();

}
