// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrit.symbolicprog;

/**
 * Watches a specific Variable to qualify another object, e.g. another Variable
 * or a Pane.
 * <p>
 * The "qualifier" variable is the one being watched; its properties control
 * whether the "qualified" Object is available or not.
 *
 * @author Bob Jacobsen Copyright (C) 2010, 2014
 *
 */
public abstract class AbstractQualifier implements Qualifier, java.beans.PropertyChangeListener {

    public AbstractQualifier(VariableValue watchedVal) {
        this.watchedVal = watchedVal;

        // set up listener
        if (watchedVal != null) {
            watchedVal.addPropertyChangeListener(this);
        }

        // subclass ctors are required to qualify on initial value of variable
        // to get initial qualification state right after listener was added.
    }

    VariableValue watchedVal;

    /**
     * Process property change from the qualifier Variable (one being watched).
     * <p>
     * Follows changes "Value" property, which it assumes is an Integer.
     * @param e The event that triggered the query
     */
    @Override
    public void propertyChange(java.beans.PropertyChangeEvent e) {
        if (e.getPropertyName().equals("Value")) {
            processValueChangeEvent(e);
        }
    }

    /**
     * Process Value property change from the qualifier Variable (one being
     * watched).
     * @param e The event that triggered the query
     */
    void processValueChangeEvent(java.beans.PropertyChangeEvent e) {
        // watched value change, check if this changes state of qualified (output) object
        boolean oldAvailableValue = currentAvailableState();
        boolean newAvailableValue = availableStateFromEvent(e);

        if (oldAvailableValue != newAvailableValue) {
            setWatchedAvailable(newAvailableValue);
        }
    }

    /**
     * Calculate whether this PropertyChangeEvent means that the qualified
     * Object should be set Available or not.
     * @param e The event that triggered the query
     * @return true if should be set available
     */
    protected boolean availableStateFromEvent(java.beans.PropertyChangeEvent e) {
        return availableStateFromValue(e.getNewValue());
    }

    /**
     * Retrieve the current "available" state from the qualified Object.
     * @return true if available
     */
    abstract protected boolean currentAvailableState();

    /**
     * Does the current value of qualifier Variable means that the
     * qualified object should be set Available or not?
     * @return true if should be set available
     */
    @Override
    abstract public boolean currentDesiredState();

    /**
     * Calculate whether a particular value for the qualifier Variable means
     * that the qualified Object should be set Available or not.
     *
     * @param value base for the calculation
     * @return true if should be set available
     */
    abstract protected boolean availableStateFromValue(Object value);

    /**
     * Drive the available or not state of the qualified Object.
     * <p>
     * Subclasses implement this to control a specific type of qualified Object,
     * like a Variable or Pane.
     * @param enable true if should be enabled
     */
    @Override
    abstract public void setWatchedAvailable(boolean enable);

}
