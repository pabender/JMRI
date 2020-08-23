// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.sensorgroup;

import jmri.*;
import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class SensorTableModelTest {

    @Test
    public void testCtor() {
        SensorTableModel t = new SensorTableModel();
        Assert.assertNotNull("exists",t);
    }

    @Test
    public void testAccessor() {

        InstanceManager.sensorManagerInstance().provideSensor("IS3").setUserName("user 3");
        InstanceManager.sensorManagerInstance().provideSensor("IS1").setUserName("user 1");
        InstanceManager.sensorManagerInstance().provideSensor("IS2").setUserName("user 2");

        SensorTableModel t = new SensorTableModel();

        Assert.assertEquals(3, t.getRowCount());   
        Assert.assertEquals("IS1", t.getValueAt(0, 0));     
        Assert.assertEquals("IS2", t.getValueAt(1, 0));     
        Assert.assertEquals("user 2", t.getValueAt(1, 1));     
    }

    @Test
    public void testAccessorAfterUpdate() {

        SensorTableModel t = new SensorTableModel();

        InstanceManager.sensorManagerInstance().provideSensor("IS3").setUserName("user 3");
        InstanceManager.sensorManagerInstance().provideSensor("IS1").setUserName("user 1");
        InstanceManager.sensorManagerInstance().provideSensor("IS2").setUserName("user 2");

        Assert.assertEquals(3, t.getRowCount());   
        Assert.assertEquals("IS1", t.getValueAt(0, 0));     
        Assert.assertEquals("IS2", t.getValueAt(1, 0));     
        Assert.assertEquals("user 2", t.getValueAt(1, 1));     
    }

    @Test
    public void testValue() {

        SensorTableModel t = new SensorTableModel();

        InstanceManager.sensorManagerInstance().provideSensor("IS3").setUserName("user 3");
        InstanceManager.sensorManagerInstance().provideSensor("IS1").setUserName("user 1");
        InstanceManager.sensorManagerInstance().provideSensor("IS2").setUserName("user 2");

        Assert.assertEquals(false, t.getValueAt(0, 2));     
        Assert.assertEquals(false, t.getValueAt(1, 2));    
        Assert.assertEquals(false, t.getValueAt(2, 2));    
        
        t.setValueAt(true, 1,2);

        Assert.assertEquals(false, t.getValueAt(0, 2));     
        Assert.assertEquals(true, t.getValueAt(1, 2));    
        Assert.assertEquals(false, t.getValueAt(2, 2));    
         
    }


    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        JUnitUtil.resetInstanceManager();
        JUnitUtil.initInternalSensorManager();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(SensorTableModelTest.class);

}
