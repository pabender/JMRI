// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.conditional;

import java.util.Locale;
import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Tests for the Bundle class
 *
 * @author Dave Sand Copyright (C) 2017
 */
public class BundleTest  {

    @Test public void testGoodKeyMessage() {
        Assert.assertEquals("Row", Bundle.getMessage("ColumnLabelRow"));  // NOI18N
    }

    @Test
    public void testBadKeyMessage() {
        Assert.assertThrows(java.util.MissingResourceException.class, () -> Bundle.getMessage("FFFFFTTTTTTT"));  // NOI18N
    }

    @Test public void testGoodKeyMessageArg() {
        Assert.assertEquals("Row", Bundle.getMessage("ColumnLabelRow", new Object[]{}));  // NOI18N
        Assert.assertEquals("Test \"test\" state is \"2\"", Bundle.getMessage("VarStateDescrpt", "Test", "test", "2"));  // NOI18N
    }

    @Test
    public void testBadKeyMessageArg() {
        Assert.assertThrows(java.util.MissingResourceException.class, () -> Bundle.getMessage("FFFFFTTTTTTT", new Object[]{}));  // NOI18N
    }

    @Test public void testLocaleMessage() {
        Assert.assertEquals("Zeile", Bundle.getMessage(Locale.GERMANY, "ColumnLabelRow"));  // NOI18N
    }

    @Test public void testLocaleMessageArg() {
        Assert.assertEquals("Zeile", Bundle.getMessage(Locale.GERMANY, "ColumnLabelRow", new Object[]{}));  // NOI18N
        // Using escape for u-with
        Assert.assertEquals("Pruefung \"pruefung\" Zustand ist 2", Bundle.getMessage(Locale.GERMANY, "VarStateDescrpt", "Pruefung", "pruefung", "2"));  // NOI18N
    }

}
