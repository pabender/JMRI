// SPDX-License-Identifier: GPL-2.0+
package apps.startup;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 *
 * @author Randall Wood 2016
 * @deprecated since 4.21.1; use {@link jmri.util.startup.PerformActionModelFactory} instead
 */
@Deprecated
@SuppressFBWarnings(value = "NM_SAME_SIMPLE_NAME_AS_SUPERCLASS", justification = "Deprecated by refactoring; retaining unchanged until removal")
public class PerformActionModelFactory extends jmri.util.startup.PerformActionModelFactory {

    public PerformActionModelFactory() {
        super();
    }
}
