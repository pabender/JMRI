// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.oaktree.serialmon;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import jmri.jmrix.oaktree.OakTreeSystemConnectionMemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Swing action to create and register a SerialMonFrame object.
 *
 * @author Bob Jacobsen Copyright (C) 2001, 2006
 */
public class SerialMonAction extends AbstractAction {

    private OakTreeSystemConnectionMemo _memo = null;

    public SerialMonAction(String s, OakTreeSystemConnectionMemo memo) {
        super(s);
        _memo = memo;
    }

    public SerialMonAction(OakTreeSystemConnectionMemo memo) {
        this(Bundle.getMessage("MonitorXTitle", "OakTree"), memo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // create a SerialMonFrame
        SerialMonFrame f = new SerialMonFrame(_memo);
        try {
            f.initComponents();
        } catch (Exception ex) {
            log.warn("SerialMonAction starting SerialMonFrame: Exception: {}", ex.toString());
        }
        f.setVisible(true);
    }

    private final static Logger log = LoggerFactory.getLogger(SerialMonAction.class);

}
