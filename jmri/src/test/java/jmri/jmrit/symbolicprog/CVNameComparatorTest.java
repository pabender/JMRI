// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.symbolicprog;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Tests for the jmri.util.AlphanumComparator class.
 *
 * @author Paul Bender Copyright 2016
 */
public class CVNameComparatorTest extends jmri.util.AlphanumComparatorTest {

    // ac is the object under test in superclass 
    @Test
    public void testDotOrder() {

        Assert.assertTrue("2 < 1.1", ac.compare("2", "1.1") < 0);
        Assert.assertTrue("1.1 > 2", ac.compare("1.1", "2") > 0);

        Assert.assertTrue("1.2 < 1.1.1", ac.compare("1.2", "1.1.1") < 0);
        Assert.assertTrue("1.1.2 > 1.2", ac.compare("1.1.1", "1.2") > 0);
        
        // odd cases
        Assert.assertTrue("2. > 1.1", ac.compare("2.", "1.1") > 0);
        Assert.assertTrue("1.1 < 2.", ac.compare("1.1", "2.") < 0);
        
        Assert.assertTrue("2. > 1..1", ac.compare("2.", "1..1") > 0);
        Assert.assertTrue("1..1 < 2.", ac.compare("1..1", "2.") < 0);

        Assert.assertTrue("1.1.1 > 1..1", ac.compare("1.1.1", "1..1") > 0);
        Assert.assertTrue("1..1 < 1.1.1", ac.compare("1..1", "1.1.1") < 0);

        Assert.assertTrue(".2. < 1.1", ac.compare(".2.", "1.1") < 0);
        Assert.assertTrue("1.1 > .2.", ac.compare("1.1", ".2.") > 0);
    }

    
    // from here down is testing infrastructure
    @BeforeEach
    @Override
    public void setUp() throws Exception {
        jmri.util.JUnitUtil.setUp();
        ac = new CVNameComparator();
    }

    @AfterEach
    @Override
    public void tearDown() throws Exception {
        jmri.util.JUnitUtil.tearDown();

    }

}
