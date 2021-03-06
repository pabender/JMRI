// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.display.palette;

import java.awt.GraphicsEnvironment;

import javax.swing.JScrollPane;

import jmri.jmrit.display.controlPanelEditor.ControlPanelEditor;
import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.jupiter.api.*;

/**
 *
 * @author Pete Cressman 2020
 */
public class ItemPanelTest {

    @Test
    public void testShowAllTabs() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        ControlPanelEditor editor = new ControlPanelEditor("EdItemPalette");
        Assert.assertNotNull("exists", editor);
        ItemPalette.getDefault("ItemPalette", editor);

        int count = ItemPalette._tabPane.getComponentCount();
        Assert.assertEquals("tab count", 16, count);
        for (int i = count-1; i>=0; i--) {
            ItemPalette._tabPane.setSelectedIndex(i);
            JScrollPane sp = (JScrollPane) ItemPalette._tabPane.getSelectedComponent();
            ItemPanel panel = (ItemPanel) sp.getViewport().getView();
            Assert.assertNotNull("ItemPanel exists", panel);
        }
        editor.dispose();
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        JUnitUtil.resetProfileManager();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.deregisterBlockManagerShutdownTask();
        JUnitUtil.tearDown();
    }

}
