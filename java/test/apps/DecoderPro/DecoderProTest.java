// SPDX-License-Identifier: GPL-2.0+
package apps.DecoderPro;

import java.io.File;
import java.io.IOException;

import jmri.util.JUnitAppender;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

/**
 * This is more of an acceptance test than a unit test, loading a series
 * of connection user profiles in DecoderPro.
 * <p>
 * It confirms that the entire application can start up and configure itself.
 * <p>
 * When format of user configuration (profile) files is changed, check the
 * sets in java/test/apps/PanelPro/profiles/ to match or allow for conversion
 * dialogs.
 * Also check the required TESTMAXTIME in {@link apps.LaunchJmriAppBase} to
 * prevent timeouts on app startup tests if structure of data develops.
 * 
 * @author Paul Bender Copyright (C) 2017, 2019
 * @author Bob Jacobsen Copyright (C) 2017
 */
@Disabled("Replaced with Cucumber test")
public class DecoderProTest extends apps.LaunchJmriAppBase {

    @Override
    protected void launch(String[] args) {
        DecoderPro.main(args);
    }

    @Test
    public void testLaunchEasyDcc(@TempDir File tempFolder) throws IOException {
        runOne(tempFolder, "EasyDcc_Simulator", "DecoderPro", "DecoderPro version");
    }

    @Test
    public void testLaunchGrapevine(@TempDir File tempFolder) throws IOException {
        runOne(tempFolder, "Grapevine_Simulator", "DecoderPro", "DecoderPro version");
        JUnitAppender.suppressWarnMessage("Timeout can't be handled due to missing node (index 1)");
        JUnitAppender.suppressWarnMessage("Timeout can't be handled due to missing node (index 0)");
    }

    @Test
    public void testLaunchLocoNet(@TempDir File tempFolder) throws IOException {
        runOne(tempFolder, "LocoNet_Simulator", "DecoderPro", "DecoderPro version");
        JUnitAppender.suppressWarnMessage("passing to xmit: unexpected exception:  [LnPowerManager LnTrackStatusUpdateThread] jmri.jmrix.loconet.LnPacketizer.sendLocoNetMessage()");
        JUnitAppender.suppressWarnMessage("passing to xmit: unexpected exception:  [LnSensorUpdateThread] jmri.jmrix.loconet.LnPacketizer.sendLocoNetMessage()");
        JUnitAppender.suppressWarnMessage("passing to xmit: unexpected exception:  [LnSensorUpdateThread] jmri.jmrix.loconet.LnPacketizer.sendLocoNetMessage()");
    }

    @Test
    public void testLaunchSprog(@TempDir File tempFolder) throws IOException {
        runOne(tempFolder, "Sprog_Simulator", "DecoderPro", "DecoderPro version");
    }

    @Test
    public void testLaunchTmcc(@TempDir File tempFolder) throws IOException {
        runOne(tempFolder, "TMCC_Simulator", "DecoderPro", "DecoderPro version");
    }

    @Test
    public void testLaunchInitLoop(@TempDir File tempFolder) throws IOException {
        runOne(tempFolder, "Prevent_Init_Loop", "DecoderPro", "DecoderPro version");
        JUnitAppender.suppressWarnMessage("passing to xmit: unexpected exception:  [LnPowerManager LnTrackStatusUpdateThread] jmri.jmrix.loconet.LnPacketizer.sendLocoNetMessage()");
        JUnitAppender.suppressWarnMessage("passing to xmit: unexpected exception:  [LnSensorUpdateThread] jmri.jmrix.loconet.LnPacketizer.sendLocoNetMessage()");
    }

}
