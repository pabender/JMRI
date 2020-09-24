// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.util;

import java.awt.GraphicsEnvironment;

import jmri.util.JUnitUtil;

import jmri.util.xml.XmlFileCheckAction;
import org.junit.jupiter.api.*;
import org.junit.Assert;
import org.junit.Assume;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class XmlFileCheckActionTest {

    @Test
    public void testCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        XmlFileCheckAction t = new XmlFileCheckAction("Test",new javax.swing.JFrame());
        Assert.assertNotNull("exists",t);
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(XmlFileCheckActionTest.class);

}
