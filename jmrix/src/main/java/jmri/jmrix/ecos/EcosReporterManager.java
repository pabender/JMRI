// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.ecos;

import javax.annotation.Nonnull;
import jmri.Reporter;

/**
 * EcosReporterManager implements the ReporterManager for ECoS
 *
 * @author Kevin Dickerson Copyright (C) 2012
 */
public class EcosReporterManager extends jmri.managers.AbstractReporterManager {

    // ctor has to register for ECoS events
    public EcosReporterManager(EcosSystemConnectionMemo memo) {
        super(memo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nonnull
    public EcosSystemConnectionMemo getMemo() {
        return (EcosSystemConnectionMemo) memo;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public Reporter createNewReporter(@Nonnull String systemName, String userName) {
        Reporter r = new EcosReporter(systemName, userName);
        register(r);
        return r;
    }

}
