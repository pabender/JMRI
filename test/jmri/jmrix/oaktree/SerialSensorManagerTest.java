//// SerialSensorManagerTest.java

package jmri.jmrix.oaktree;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * JUnit tests for the SerialSensorManager class.
 * @author	Bob Jacobsen  Copyright 2003
 * @version	$Revision: 1.3 $
 */
public class SerialSensorManagerTest extends TestCase {

    public void testSensorCreationAndRegistration() {
        SerialNode n0 = new SerialNode();
        SerialNode n1 = new SerialNode(1,SerialNode.IO48);
        SerialNode n2 = new SerialNode(2,SerialNode.IO24);
        SerialSensorManager s = new SerialSensorManager();
        Assert.assertTrue("none expected A0", !(n0.sensorsActive()) );
        Assert.assertTrue("none expected A1", !(n1.sensorsActive()) );
        Assert.assertTrue("none expected A2", !(n2.sensorsActive()) );
        s.provideSensor("3");
        Assert.assertTrue("UA 0", n0.sensorsActive() );
        Assert.assertTrue("2nd none expected A1", !(n1.sensorsActive()) );
        Assert.assertTrue("2nd none expected A2", !(n2.sensorsActive()) );
        s.provideSensor("11");
        s.provideSensor("8");
        s.provideSensor("19");
        s.provideSensor("23");
        s.provideSensor("OS2006");
        Assert.assertTrue("2nd UA 0", n0.sensorsActive() );
        Assert.assertTrue("3rd none expected UA 1", !(n1.sensorsActive()) );
        Assert.assertTrue("UA 2", n2.sensorsActive() );
        s.provideSensor("15");
        s.provideSensor("1001");
        Assert.assertTrue("3rd UA 0", n0.sensorsActive() );
        Assert.assertTrue("UA 1", n1.sensorsActive() );
        Assert.assertTrue("2nd UA 2", n0.sensorsActive() );
        s.provideSensor("17");
        s.provideSensor("1017");
        s.provideSensor("2007");
        Assert.assertTrue("4th UA 0", n0.sensorsActive() );
        Assert.assertTrue("2nd UA 1", n1.sensorsActive() );
        Assert.assertTrue("3rd UA 2", n0.sensorsActive() );
    }

    // from here down is testing infrastructure
    public SerialSensorManagerTest(String s) {
        super(s);
    }

    // Main entry point
    static public void main(String[] args) {
        String[] testCaseName = {"-noloading", SerialSensorManagerTest.class.getName()};
        junit.swingui.TestRunner.main(testCaseName);
    }

    // test suite from all defined tests
    public static Test suite() {
        TestSuite suite = new TestSuite(SerialSensorManagerTest.class);
        return suite;
    }

    // The minimal setup for log4J
    protected void setUp() { apps.tests.Log4JFixture.setUp(); }
    protected void tearDown() { apps.tests.Log4JFixture.tearDown(); }

}
