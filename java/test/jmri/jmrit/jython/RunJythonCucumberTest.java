package jmri.jmrit.jython;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Trigger file for Jython Cucumber tests.
 * <p>
 * This file provides default options for cucumber.</p>
 * <p>
 * To override those using maven add -Dcucumber.options="..." to the maven
 * command line
 * </p>
 * <p>
 * To override those in ant, run:<br/>
 * JAVA_OPTIONS='-Dcucumber.options="..."' ant target
 * </p>
 * @author	Paul Bender Copyright 2017
 */

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"junit:cucumber-results.xml","progress"},
                 features = "jython/acceptancetests/features",
                 glue= "jython/acceptancetests/glue",
                 tags = {"~@webtest"})
public class RunJythonCucumberTest {
   
   @BeforeClass
   public static void beforeTests(){
      jmri.util.JUnitUtil.setUp();
      //jmri.script.JmriScriptEngineManager.getDefault();
   }

   @AfterClass
   public static void afterTests(){
      jmri.util.JUnitUtil.tearDown();
   }

}
