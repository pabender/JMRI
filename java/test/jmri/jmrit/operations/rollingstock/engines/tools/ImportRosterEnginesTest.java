// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.operations.rollingstock.engines.tools;

import jmri.jmrit.operations.OperationsTestCase;
import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class ImportRosterEnginesTest extends OperationsTestCase {

    @Test
    public void testCTor() {
        ImportRosterEngines t = new ImportRosterEngines();
        Assert.assertNotNull("exists",t);
    }

    // private final static Logger log = LoggerFactory.getLogger(ImportRosterEnginesTest.class);

}
