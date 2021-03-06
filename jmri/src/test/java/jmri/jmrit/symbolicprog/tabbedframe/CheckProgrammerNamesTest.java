// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.symbolicprog.tabbedframe;

import java.io.File;

import jmri.util.xml.XmlFile;
import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Check the names in an XML programmer file against the names.xml definitions
 *
 * @author Bob Jacobsen Copyright (C) 2001, 2007, 2008
 * @see XmlFile
 */
public class CheckProgrammerNamesTest {

    @Test
    public void testAdvanced() {
        checkAgainstNames(new File("xml/programmers/Advanced.xml"));
    }

    @Test
    public void testComprehensive() {
        checkAgainstNames(new File("xml/programmers/Comprehensive.xml"));
    }

    @Test
    public void testBasic() {
        checkAgainstNames(new File("xml/programmers/Basic.xml"));
    }

    @Test
    public void testTrainShowBasic() {
        checkAgainstNames(new File("xml/programmers/TrainShowBasic.xml"));
    }

    @Test
    public void testSampleClub() {
        checkAgainstNames(new File("xml/programmers/Sample Club.xml"));
    }

    @Test
    public void testCustom() {
        checkAgainstNames(new File("xml/programmers/Custom.xml"));
    }

    @Test
    public void testTutorial() {
        checkAgainstNames(new File("xml/programmers/Tutorial.xml"));
    }

    @Test
    public void testRegisters() {
        checkAgainstNames(new File("xml/programmers/Registers.xml"));
    }

    @Test
    @Disabled("Preexisting failing condition")
    public void testESU() {
        checkAgainstNames(new File("xml/programmers/ESU.xml"));
    }

    @Test
    @Disabled("Preexisting failing condition")
    public void testZimo() {
        checkAgainstNames(new File("xml/programmers/Zimo.xml"));
    }

    @Test
    public void testComprehensiveComplete() {
        checkComplete(new File("xml/programmers/Comprehensive.xml"));
    }

    @Test
    public void testAdvancedComplete() {
        checkComplete(new File("xml/programmers/Advanced.xml"));
    }

    // utilities
    public void checkAgainstNames(File file) {
        String result = ProgCheckAction.checkMissingNames(file);
        if (!result.equals("")) {
            Assert.fail(result);
        }
    }

    public void checkComplete(File file) {
        String result = ProgCheckAction.checkIncompleteComprehensive(file);
        if (!result.equals("")) {
            Assert.fail(result);
        }
    }

    @BeforeEach
    public void setUp() throws Exception {
        jmri.util.JUnitUtil.setUp();
    }

    @AfterEach
    public void tearDown() throws Exception {
        jmri.util.JUnitUtil.tearDown();

    }
}
