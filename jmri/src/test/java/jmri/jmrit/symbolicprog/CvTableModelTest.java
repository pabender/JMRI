// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.symbolicprog;

import javax.swing.JLabel;
import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * @author Bob Jacobsen
 */
public class CvTableModelTest {

    @Test
    public void testStart() {
        Assert.assertNotNull(new CvTableModel(new JLabel(), null));
    }

    // private final static Logger log = LoggerFactory.getLogger(CvTableModelTest.class);

}
