// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.plaf.macosx;

import java.util.EventObject;

/**
 * Handle a trigger to launch the application preferences from Mac OS X.
 *
 * @author Randall Wood (c) 2011
 * @deprecated since 4.21.1; use {@link apps.plaf.macosx.PreferencesHandler} instead
 */
@Deprecated
public interface PreferencesHandler {

    abstract public void handlePreferences(EventObject eo);

}
