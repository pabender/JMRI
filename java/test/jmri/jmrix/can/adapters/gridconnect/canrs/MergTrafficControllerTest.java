package jmri.jmrix.can.adapters.gridconnect.canrs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ResourceBundle;
import jmri.InstanceManager;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import jmri.jmrix.AbstractMRListener;
import jmri.jmrix.AbstractMRMessage;
import jmri.jmrix.AbstractMRReply;

/**
 * Tests for MergTrafficController.
 * @author Paul Bender Copyright (C) 2016
 */
public class MergTrafficControllerTest extends jmri.jmrix.can.adapters.gridconnect.GcTrafficControllerTest {

    @Override
    @Test
    public void testGetCanid(){
        Assert.assertEquals("default canid value",122,((MergTrafficController)tc).getCanid());
    }

   
    @Override
    @Before
    public void setUp() {
        apps.tests.Log4JFixture.setUp(); 
        JUnitUtil.resetInstanceManager();
        tc = new MergTrafficController();
    }

    @Override
    @After
    public void tearDown(){
       tc = null;
        JUnitUtil.resetInstanceManager();
        apps.tests.Log4JFixture.tearDown(); 
    }

}
