// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrix.powerline;

import jmri.jmrix.AbstractMRListener;
import jmri.jmrix.AbstractMRMessage;
import jmri.jmrix.AbstractMRReply;
import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

/**
 * Tests for SerialTrafficController.
 * @author Paul Bender Copyright (C) 2016
 */
public class SerialTrafficControllerTest extends jmri.jmrix.AbstractMRTrafficControllerTest {
    
    @Override
    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp(); 
        JUnitUtil.resetInstanceManager();
        tc = new SerialTrafficController(){
           @Override
           protected void forwardMessage(AbstractMRListener client, AbstractMRMessage m){
           }
           @Override
           protected AbstractMRMessage pollMessage(){ return null; }
           @Override
           protected AbstractMRListener pollReplyHandler() { return null; }
           @Override
           protected AbstractMRMessage enterProgMode() { return null; }
           @Override
           protected AbstractMRMessage enterNormalMode() { return null; }
           @Override
           protected void forwardReply(AbstractMRListener client, AbstractMRReply m){}
           @Override
           protected AbstractMRReply newReply() { return null; }
           @Override
           protected boolean endOfMessage(AbstractMRReply r) {return true; }
        };
    }

    @Override
    @AfterEach
    public void tearDown(){

        tc = null;
        JUnitUtil.clearShutDownManager(); // put in place because AbstractMRTrafficController implementing subclass was not terminated properly
        JUnitUtil.tearDown();
 
    }

}
