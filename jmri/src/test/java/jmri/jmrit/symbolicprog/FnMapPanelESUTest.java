// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.symbolicprog;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import jmri.roster.RosterEntry;

import org.jdom2.Element;
import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class FnMapPanelESUTest {

    @Test
    public void testV4() {
        List<Integer> varsUsed = new ArrayList<>();
        RosterEntry re = new RosterEntry();
        Element model = new Element("model");
        model.setAttribute("extFnsESU", "V4");

        FnMapPanelESU t = new FnMapPanelESU(tableModel, varsUsed, model,re,cvtm);
        Assert.assertNotNull("exists",t);
        t.dispose();
    }

    @Test
    public void testV5() {
        List<Integer> varsUsed = new ArrayList<>();
        RosterEntry re = new RosterEntry();
        Element model = new Element("model");
        model.setAttribute("extFnsESU", "V5");

        FnMapPanelESU t = new FnMapPanelESU(tableModel, varsUsed, model,re,cvtm);
        Assert.assertNotNull("exists",t);
        t.dispose();
    }

    jmri.Programmer p;
    CvTableModel cvtm;
    VariableTableModel tableModel;
    
    @BeforeEach
    public void setUp() {
        jmri.util.JUnitUtil.setUp();
        jmri.util.JUnitUtil.initDebugProgrammerManager();
        
        p = jmri.InstanceManager.getDefault(jmri.GlobalProgrammerManager.class).getGlobalProgrammer();
        cvtm = new CvTableModel(new JLabel(), p);
        tableModel = new VariableTableModel(
                new JLabel(""),
                new String[]{"Name", "Value"},
                cvtm
        );
    }

    @AfterEach
    public void tearDown() {
        p = null;
        tableModel.dispose();
        tableModel = null;
        cvtm.dispose();
        cvtm = null; 

        jmri.util.JUnitUtil.tearDown();
    }

}
