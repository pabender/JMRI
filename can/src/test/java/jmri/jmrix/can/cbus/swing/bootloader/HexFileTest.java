// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.can.cbus.swing.bootloader;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Tests for the HexFile class
 *
 * @author Bob Andrew Crosland (C) 2020
 */
public class HexFileTest {

    @Test
    public void testCTor() {
        HexFile f = new HexFile("cbusHexFileTest");
        Assert.assertNotNull("exists",f);
    }
    
}
