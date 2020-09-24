// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.managers;

import jmri.*;
import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Base for the various Abstract*MgrTestBase base classes for NamedBean Manager test classes
 * <p>
 * This is not itself a test class, e.g. should not be added to a suite.
 * Instead, this forms the base for test classes, including providing some
 * common tests.
 * <p>
 * Quite a bit of AbstractManager testing is done in InternalSensorManagerTest
 * to give it a concrete platform
 *
 * @author Bob Jacobsen Copyright (C) 2017
 */
public abstract class AbstractProxyManagerTestBase<T extends Manager<E>, E extends NamedBean> {

    // ProxyManager<E> under test - setUp() loads this
    protected T l = null;

    @Test
    public final void testMakeSystemName() {
        String s = l.makeSystemName("1");
        Assert.assertTrue(s != null);
        Assert.assertTrue(! s.isEmpty());
    }
}
