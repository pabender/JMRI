// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.sprog;

import java.awt.GraphicsEnvironment;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.Assume;

import jmri.jmrix.sprog.SprogSystemConnectionMemo;

/**
 * Test simple functioning of SPROGMenu.
 *
 * @author Paul Bender Copyright (C) 2016
 */
public class SPROGMenuTest {

    @Test
    public void testCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless()); 
        // the constructor looks for the default ListedTableFrame class, 
        // which is set by the ListedTableFrame constructor.
        new jmri.beantable.ListedTableFrame();
        SprogSystemConnectionMemo memo = new SprogSystemConnectionMemo();
        SPROGMenu action = new SPROGMenu(memo);
        Assert.assertNotNull("exists", action);
        memo.dispose();
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        JUnitUtil.initDefaultUserMessagePreferences();
    }

    @AfterEach
    public void tearDown() {        JUnitUtil.tearDown();    }

}
