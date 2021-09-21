package jmri.jmrit.logixng.expressions;

import java.util.Locale;
import java.util.Map;

import jmri.InstanceManager;
import jmri.jmrit.logixng.*;

/**
 * Always evaluates to True.
 * 
 * @author Daniel Bergqvist Copyright 2018
 */
public class True extends AbstractDigitalExpression {

    public True(String sys, String user)
            throws BadUserNameException, BadSystemNameException {
        super(sys, user);
    }
    
    @Override
    public Base getDeepCopy(Map<String, String> systemNames, Map<String, String> userNames) {
        DigitalExpressionManager manager = InstanceManager.getDefault(DigitalExpressionManager.class);
        String sysName = systemNames.get(getSystemName());
        String userName = userNames.get(getSystemName());
        if (sysName == null) sysName = manager.getAutoSystemName();
        DigitalExpressionBean copy = new True(sysName, userName);
        copy.setComment(getComment());
        return manager.registerExpression(copy);
    }
    
    /** {@inheritDoc} */
    @Override
    public Category getCategory() {
        return Category.OTHER;
    }
    
    /** {@inheritDoc} */
    @Override
    public boolean evaluate() {
        return true;
    }
    
    @Override
    public FemaleSocket getChild(int index) throws IllegalArgumentException, UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported.");
    }
    
    @Override
    public int getChildCount() {
        return 0;
    }
    
    @Override
    public String getShortDescription(Locale locale) {
        return Bundle.getMessage(locale, "True_Short");
    }
    
    @Override
    public String getLongDescription(Locale locale) {
        return Bundle.getMessage(locale, "True_Long");
    }

    /** {@inheritDoc} */
    @Override
    public void setup() {
        // Do nothing
    }
    
    /** {@inheritDoc} */
    @Override
    public void registerListenersForThisClass() {
    }
    
    /** {@inheritDoc} */
    @Override
    public void unregisterListenersForThisClass() {
    }
    
    /** {@inheritDoc} */
    @Override
    public void disposeMe() {
    }

}
