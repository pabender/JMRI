// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.tracker;

import org.junit.jupiter.api.*;

import jmri.Block;
import jmri.InstanceManager;
import jmri.MemoryManager;

/**
 * Tests for the MemoryTracker class
 *
 * @author Bob Jacobsen Copyright (C) 2006
 */
public class MemoryTrackerTest {

    @Test
    public void testDirectCreate() {
        MemoryManager m = InstanceManager.memoryManagerInstance();
        jmri.InstanceManager.store(new jmri.NamedBeanHandleManager(), jmri.NamedBeanHandleManager.class);
        m.provideMemory("dummy");
        // check for exception in ctor
        new MemoryTracker(new Block("dummy"), "");
    }

    @BeforeEach
    public void setUp() {
        jmri.util.JUnitUtil.setUp();
    }

    @AfterEach
    public void tearDown() {
        jmri.util.JUnitUtil.tearDown();
    }

}
