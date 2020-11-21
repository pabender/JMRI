// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.loconet.swing;

import jmri.*;
import jmri.implementation.DccSignalMast;
import jmri.beantable.signalmast.SignalMastAddPane;
import jmri.jmrix.loconet.LNCPSignalMast;
import jmri.jmrix.loconet.SlotManager;

import javax.annotation.Nonnull;

import org.openide.util.lookup.ServiceProvider;

/**
 * A pane for configuring LNCPSignalMast objects
 *
 * @see jmri.beantable.signalmast.SignalMastAddPane
 * @author Bob Jacobsen Copyright (C) 2018
 * @since 4.11.2
 */
public class LNCPSignalMastAddPane extends jmri.beantable.signalmast.DccSignalMastAddPane {

    public LNCPSignalMastAddPane() {
        super();
    }
    
    /** {@inheritDoc} */
    @Override
    @Nonnull public String getPaneName() {
        return Bundle.getMessage("LNCPMast");
    }

    /** {@inheritDoc} */
    @Override
    public boolean canHandleMast(@Nonnull SignalMast mast) {
        return mast instanceof LNCPSignalMast;
    }

    /** {@inheritDoc} */
    @Override
    protected String getNamePrefix() {
        return "F$lncpsm:";
    }

    /** {@inheritDoc} */
    @Override
    protected DccSignalMast constructMast(String name) {
        return new LNCPSignalMast(name);
    }

    /** {@inheritDoc} */
    @Override
    protected boolean usableCommandStation(CommandStation cs) {
        return cs instanceof jmri.jmrix.loconet.SlotManager;
    }

    @ServiceProvider(service = SignalMastAddPane.SignalMastAddPaneProvider.class)
    static public class SignalMastAddPaneProvider extends SignalMastAddPane.SignalMastAddPaneProvider {
        /**
         * {@inheritDoc}
         * Requires a valid LocoNet connection
         */
        @Override
        public boolean isAvailable() {
            for (CommandStation c : InstanceManager.getList(CommandStation.class)) {
                if (c instanceof SlotManager) {
                    return true;
                }
            }
            return false;
        }

        /** {@inheritDoc} */
        @Override
        @Nonnull public String getPaneName() {
            return Bundle.getMessage("LNCPMast");
        }
        /** {@inheritDoc} */
        @Override
        @Nonnull public SignalMastAddPane getNewPane() {
            return new LNCPSignalMastAddPane();
        }
    }
}
