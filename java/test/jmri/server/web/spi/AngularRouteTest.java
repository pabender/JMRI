// SPDX-License-Identifier: GPL-2.0+
package jmri.server.web.spi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.*;

/**
 *
 * @author Randall Wood (C) 2017
 */
public class AngularRouteTest {

    @BeforeEach
    public void setUp() throws Exception {
        jmri.util.JUnitUtil.setUp();

    }

    @AfterEach
    public void tearDown() throws Exception {
        jmri.util.JUnitUtil.tearDown();

    }

    @Test
    public void testGetConstructor() {
        try {
            new AngularRoute(null, "b", "c", "d");
            fail("NPE should have been thrown");
        } catch (NullPointerException ex) {
            // ignore, as expected
        }
        try {
            new AngularRoute("a", "b", "c", "d");
            fail("IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException ex) {
            // ignore, as expected
        }
        try {
            new AngularRoute("a", null, null, null);
            fail("IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException ex) {
            // ignore, as expected
        }
        try {
            new AngularRoute("a", null, "c", "d");
            fail("IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException ex) {
            // ignore, as expected
        }
        try {
            new AngularRoute("a", "b", null, "d");
            fail("IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException ex) {
            // ignore, as expected
        }
        try {
            new AngularRoute("a", null, null, "d");
        } catch (IllegalArgumentException ex) {
            fail("IllegalArgumentException should not have been thrown");
        }
        try {
            new AngularRoute("a", "b", "c", null);
        } catch (IllegalArgumentException ex) {
            fail("IllegalArgumentException should not have been thrown");
        }
    }

    @Test
    public void testGetRedirection() {
        AngularRoute ar = new AngularRoute("a", null, null, "d");
        assertEquals("d", ar.getRedirection());
        ar = new AngularRoute("a", "b", "c", null);
        assertNull(ar.getRedirection());
    }

    @Test
    public void testGetWhen() {
        AngularRoute ar = new AngularRoute("a", null, null, "d");
        assertEquals("a", ar.getWhen());
    }

    @Test
    public void testGetTemplate() {
        AngularRoute ar = new AngularRoute("a", null, null, "d");
        assertNull(ar.getTemplate());
        ar = new AngularRoute("a", "b", "c", null);
        assertEquals("b", ar.getTemplate());
    }

    @Test
    public void testGetController() {
        AngularRoute ar = new AngularRoute("a", null, null, "d");
        assertNull(ar.getController());
        ar = new AngularRoute("a", "b", "c", null);
        assertEquals("c", ar.getController());
    }

}
