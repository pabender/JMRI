// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrix.loconet.slotmon;

import jmri.jmrix.loconet.LnTrafficController;
import jmri.jmrix.loconet.LocoNetInterfaceScaffold;
import jmri.jmrix.loconet.LocoNetSystemConnectionMemo;
import jmri.jmrix.loconet.SlotManager;
import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class SlotMonPaneTest extends jmri.util.swing.JmriPanelTest {

    @Override
    @Test
    public void testInitComponents() {
        SlotMonPane t = new SlotMonPane();
        LnTrafficController lnis = new LocoNetInterfaceScaffold();
        SlotManager slotmanager = new SlotManager(lnis);
        LocoNetSystemConnectionMemo memo = new LocoNetSystemConnectionMemo(lnis,slotmanager);
        // we are just making sure that initComponents doesn't cause an exception.
        t.initComponents(memo);
        memo.dispose();
    }

    @Override
    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        panel = new SlotMonPane();
        helpTarget="package.jmri.jmrix.loconet.slotmon.SlotMonFrame";
        title=Bundle.getMessage("MenuItemSlotMonitor");
    }

    @Override
    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(SlotMonPaneTest.class);

}
