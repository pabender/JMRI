// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.beantable;

import jmri.InstanceManager;
import jmri.SignalMastLogic;
import jmri.implementation.VirtualSignalMast;
import jmri.util.JUnitUtil;
import jmri.util.swing.JemmyUtil;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.jupiter.api.*;
import org.netbeans.jemmy.operators.*;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 * @author Egbert Broerse Copyright (C) 2019
 */
public class SignalMastLogicTableActionTest extends AbstractTableActionBase<SignalMastLogic> {

    @Test
    public void testCTor() {
        Assert.assertNotNull("exists", a);
    }

    @Override
    public String getTableFrameName(){
       return Bundle.getMessage("TitleSignalMastLogicTable");
    }

    /**
     * Check the return value of includeAddButton. The table generated by
     * this action includes an Add Button.
     */
    @Override
    @Test
    public void testIncludeAddButton(){
         Assert.assertTrue("Default include add button", a.includeAddButton());
    }

    @Override
    public String getAddFrameName(){
        ResourceBundle rb = ResourceBundle.getBundle("jmri.jmrit.signalling.SignallingBundle");
        return rb.getString("SignallingPairs"); // "Signaling Mast Pairs" can't use Bundle i18n as not in path
    }

    @Test
    @Override
    @Disabled("no add button on signal mast logic table")
    public void testAddButton() {
    }

    @Test
    @Override
    @Disabled("no add button on signal mast logic table")
    public void testAddThroughDialog() {
    }

    @Test
    @Override

    public void testEditButton() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());

        VirtualSignalMast sm1 = new VirtualSignalMast("IF$vsm:basic:one-searchlight($1)", "mast 1");
        VirtualSignalMast sm2 = new VirtualSignalMast("IF$vsm:basic:one-searchlight($2)", "mast 2");
        // provide a signal mast logic:
        SignalMastLogic sml = InstanceManager.getDefault(jmri.SignalMastLogicManager.class).newSignalMastLogic(sm1);
        sml.setDestinationMast(sm2);
        Assert.assertNotNull("SignalMastLogic is null!", sml);
        sml.allowAutoMaticSignalMastGeneration(false, sm2);

        a.actionPerformed(null);
        JFrame f = JFrameOperator.waitJFrame(Bundle.getMessage("TitleSignalMastLogicTable"), true, true);
        Assert.assertNotNull("found frame", f);

        //new org.netbeans.jemmy.QueueTool().waitEmpty();
        JFrameOperator jfo = new JFrameOperator(f);
        JTableOperator tbl = new JTableOperator(jfo, 0);

        tbl.setValueAt("new comment", 0, 4); // COMCOL
        tbl.setValueAt(false, 0, 6);         // ENABLECOL

        // find the "Edit" button and press it.  This is in the table body.
        tbl.clickOnCell(0, 7); // EDITCOL

        JFrame f2 = JFrameOperator.waitJFrame(getAddFrameName(), true, true);
        JemmyUtil.pressButton(new JFrameOperator(f2), Bundle.getMessage("ButtonCancel"));

        // find the "Delete" button and press it.  This is in the table body.
        tbl.clickOnCell(0, 5);

        JUnitUtil.dispose(f2);
        JUnitUtil.dispose(f);
        sml.dispose();
    }

    @Test
    public void testSmlTableMenuRoutingCancel() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());

        a.actionPerformed(null);
        JFrame f = JFrameOperator.waitJFrame(Bundle.getMessage("TitleSignalMastLogicTable"), true, true);
        JFrameOperator jfo = new JFrameOperator(f);

        // Use GUI menu to open Tools menus:
        // Option1 is a modal JOptionPane, so create a thread to dismiss it.
        Thread t = new Thread(() -> {
            try {
                JemmyUtil.confirmJOptionPane(jfo, Bundle.getMessage("TitleBlockRouting"),
                        Bundle.getMessage("EnableLayoutBlockRouting"), "No");
            } catch( org.netbeans.jemmy.TimeoutExpiredException tee) {
                // we're waiting for this thread to finish in the main method,
                // so any exception here means we failed.
                log.error("caught timeout exception while waiting for modal dialog in SignalMastLogicTableActionTest", tee);
            }
        });
        t.setName("Cancel Routing Dialog Close Thread");
        t.start();

        JMenuBarOperator mainbar = new JMenuBarOperator(jfo);
        mainbar.pushMenu(Bundle.getMessage("MenuTools")); // stops at top level
        JMenuOperator jmo = new JMenuOperator(mainbar, Bundle.getMessage("MenuTools"));
        JPopupMenu jpm = jmo.getPopupMenu();

        // Menu AutoCreate
        JMenuItem findMenuItem = (JMenuItem) jpm.getComponent(0);
        Assert.assertEquals(findMenuItem.getText(), (Bundle.getMessage("MenuItemAutoGen")));
        new JMenuItemOperator(findMenuItem).doClick();

        // wait for the dismiss thread to finish
        JUnitUtil.waitFor(()-> { return !t.isAlive();
        }, "Cancel Routing Dialog Close Thread finished");

        // clean up
        JUnitUtil.dispose(f);
    }

    @Test
    public void testSmlTableMenuYes() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());

        a.actionPerformed(null);
        JFrame f = JFrameOperator.waitJFrame(Bundle.getMessage("TitleSignalMastLogicTable"), true, true);
        JFrameOperator jfo = new JFrameOperator(f);

        // Use GUI menu to open Tools menus:
        // Option1 is a modal JOptionPane, so create a thread to dismiss it.
        Thread t = new Thread(() -> {
            try {
                JemmyUtil.confirmJOptionPane(jfo, Bundle.getMessage("TitleBlockRouting"),
                        Bundle.getMessage("EnableLayoutBlockRouting"), "Yes");
            } catch( org.netbeans.jemmy.TimeoutExpiredException tee) {
                // we're waiting for this thread to finish in the main method,
                // so any exception here means we failed.
                log.error("caught timeout exception while waiting for modal dialog in SignalMastLogicTableActionTest", tee);
            }
        });
        t.setName("Activate Routing Dialog Close Thread");
        t.start();

        // Option2 is a modal JOptionPane, so create a thread to dismiss it.
        Thread t2 = new Thread(() -> {
            try {
                JemmyUtil.confirmJOptionPane(jfo, "Message",
                        Bundle.getMessage("LayoutBlockRoutingEnabled"), "OK");
            } catch( org.netbeans.jemmy.TimeoutExpiredException tee) {
                // we're waiting for this thread to finish in the main method,
                // so any exception here means we failed.
                log.error("caught timeout exception while waiting for modal dialog in SignalMastLogicTableActionTest", tee);
            }
        });
        t2.setName("Confirm Routing Activated Dialog Close Thread");
        t2.start();

        // Option3 is a modal JOptionPane, so create a thread to dismiss it.
        Thread t3 = new Thread(() -> {
            try {
                JemmyUtil.confirmJOptionPane(jfo, Bundle.getMessage("AutoGenSignalMastLogicTitle"),
                        Bundle.getMessage("AutoGenSignalMastLogicMessage"), "Yes"); // Message text not complete, but functional
            } catch( org.netbeans.jemmy.TimeoutExpiredException tee) {
                // we're waiting for this thread to finish in the main method,
                // so any exception here means we failed.
                log.error("caught timeout exception while waiting for modal dialog in SignalMastLogicTableActionTest", tee);
            }
        });
        t3.setName("LE Autorouting Dialog Close Thread");
        t3.start();

        JMenuBarOperator mainbar = new JMenuBarOperator(jfo);
        mainbar.pushMenu(Bundle.getMessage("MenuTools")); // stops at top level
        JMenuOperator jmo = new JMenuOperator(mainbar, Bundle.getMessage("MenuTools"));
        JPopupMenu jpm = jmo.getPopupMenu();

        // Menu AutoCreate
        JMenuItem findMenuItem = (JMenuItem) jpm.getComponent(0);
        Assert.assertEquals(findMenuItem.getText(), (Bundle.getMessage("MenuItemAutoGen")));
        new JMenuItemOperator(findMenuItem).doClick();

        // wait for the dismiss thread to finish
        JUnitUtil.waitFor(()-> { return !t.isAlive();
        }, "Activate Routing Dialog Close Thread finished");

        // wait for the dismiss thread2 to finish
        JUnitUtil.waitFor(()-> { return !t2.isAlive();
        }, "Confirm Routing Activated Close Thread finished");

        // wait for the dismiss thread3 to finish
        JUnitUtil.waitFor(()-> { return !t3.isAlive();
        }, "Cancel LE Autorouting Thread finished");

        // clean up
        JUnitUtil.dispose(f);
    }

    @Test
    public void testSmlTableMenuAutoSections() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());

        a.actionPerformed(null);
        JFrame f = JFrameOperator.waitJFrame(Bundle.getMessage("TitleSignalMastLogicTable"), true, true);
        JFrameOperator jfo = new JFrameOperator(f);

        // Use GUI menu to open Tools menus:
        // Option1 is a modal JOptionPane, so create a thread to dismiss it.
        Thread t = new Thread(() -> {
            try {
                JemmyUtil.confirmJOptionPane(jfo, "Message",
                        Bundle.getMessage("SectionGenerationComplete"), "OK");
            } catch( org.netbeans.jemmy.TimeoutExpiredException tee) {
                // we're waiting for this thread to finish in the main method,
                // so any exception here means we failed.
                log.error("caught timeout exception while waiting for modal dialog", tee);
            }
        });
        t.setName("Auto SectionComplete Dialog Close Thread");
        t.start();

        JMenuBarOperator mainbar = new JMenuBarOperator(jfo);
        mainbar.pushMenu(Bundle.getMessage("MenuTools")); // stops at top level
        JMenuOperator jmo = new JMenuOperator(mainbar, Bundle.getMessage("MenuTools"));
        JPopupMenu jpm = jmo.getPopupMenu();

        // Menu AutoCreate
        JMenuItem findMenuItem = (JMenuItem) jpm.getComponent(1);
        Assert.assertEquals(findMenuItem.getText(), (Bundle.getMessage("MenuItemAutoGenSections")));
        new JMenuItemOperator(findMenuItem).doClick();

        // wait for the dismiss thread to finish
        JUnitUtil.waitFor(()-> { return !t.isAlive();
        }, "Auto Section Complete Close Thread finished");

        // clean up
        JUnitUtil.dispose(f);
    }

    @Override
    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        jmri.util.JUnitUtil.resetProfileManager();
        helpTarget = "package.jmri.jmrit.beantable.SignalMastLogicTable"; 
        a = new SignalMastLogicTableAction();
    }

    @Override
    @AfterEach
    public void tearDown() {
        JUnitUtil.resetWindows(false,false);
        JUnitUtil.deregisterBlockManagerShutdownTask();
        JUnitUtil.tearDown();
    }

    private final static Logger log = LoggerFactory.getLogger(SignalMastLogicTableActionTest.class);

}
