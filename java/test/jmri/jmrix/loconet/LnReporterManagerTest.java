package jmri.jmrix.loconet;

import jmri.Reportable;
import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the LnReporterManager class
 *
 * @author Paul Bender Copyright (C) 2012,2016
 */
public class LnReporterManagerTest extends jmri.managers.AbstractReporterMgrTestBase {

    @Override
    public String getSystemName(String i) {
        return "LR" + i;
    }

    private LnTrafficController tc = null;

    @Test
    public void testEnterBeforeExit(){
        LnReporter r1 = (LnReporter) ((LnReporterManager)l).provideReporter("LR1");
        LnReporter r2 = (LnReporter) ((LnReporterManager)l).provideReporter("LR2");
        r2.messageFromManager(new LocoNetMessage(new int[]{0xD0, 0x20, 0x01, 0x7D, 0x03, 0x73}));  // send enter LR2
        assertThat(r2.getCurrentReport()).isNotNull().isInstanceOf(TranspondingTag.class);
        assertThat(((Reportable)r2.getCurrentReport()).toReportString()).contains("enter");
        assertThat(r1.getCurrentReport()).isNull();
        r1.messageFromManager(new LocoNetMessage(new int[]{0xD0, 0x20, 0x00, 0x7D, 0x03, 0x73}));  // send enter LR1
        assertThat(r1.getCurrentReport()).isNotNull().isInstanceOf(TranspondingTag.class);
        assertThat(((Reportable)r1.getCurrentReport()).toReportString()).contains("enter");
        assertThat(r2.getCurrentReport()).isNull();
        r2.messageFromManager(new LocoNetMessage(new int[]{0xD0, 0x00, 0x01, 0x7D, 0x03, 0x53}));  // send exit LR2
        assertThat(r1.getCurrentReport()).isNotNull().isInstanceOf(TranspondingTag.class);
        assertThat(((Reportable)r1.getCurrentReport()).toReportString()).contains("exit");
        assertThat(r2.getCurrentReport()).isNull();
    }

    @BeforeEach
    @Override
    public void setUp() {
        JUnitUtil.setUp();
        tc = new LocoNetInterfaceScaffold(new LocoNetSystemConnectionMemo());
        l = new LnReporterManager(tc.getSystemConnectionMemo());
        new TranspondingTagManager();
    }

    @AfterEach
    public void tearDown() {
        tc = null;
        jmri.InstanceManager.getDefault(TranspondingTagManager.class).dispose();
        jmri.util.JUnitUtil.clearShutDownManager();
        JUnitUtil.tearDown();
    }

    @Override
    protected int maxN() { return 1; }

}
