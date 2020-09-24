// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.rfid;

import jmri.util.JUnitUtil;

import org.junit.jupiter.api.*;

/**
 * JUnit tests for the RfidNetworkPortController class.
 *
 * @author      Paul Bender Copyright (C) 2016
 */
public class RfidNetworkPortControllerTest extends jmri.jmrix.AbstractNetworkPortControllerTestBase {

    @Override
    @BeforeEach
    public void setUp(){
       JUnitUtil.setUp();
       RfidSystemConnectionMemo memo = new RfidSystemConnectionMemo();
       apc = new RfidNetworkPortController(memo){
            @Override
            public void configure(){
            }
       };
    }

    @Override
    @AfterEach
    public void tearDown(){
       JUnitUtil.tearDown();
    }

}
