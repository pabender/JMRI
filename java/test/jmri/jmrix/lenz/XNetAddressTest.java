package jmri.jmrix.lenz;

import jmri.Manager;
import jmri.util.JUnitAppender;
import jmri.util.JUnitUtil;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class XNetAddressTest {

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    @Test
    void getBitFromSystemName() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(XNetAddress.getBitFromSystemName("XT1","X")).isEqualTo(1);
        softly.assertThat(XNetAddress.getBitFromSystemName("XT21","X")).isEqualTo(21);
        softly.assertThat(XNetAddress.getBitFromSystemName("XS1","X")).isEqualTo(1);
        softly.assertThat(XNetAddress.getBitFromSystemName("XS21","X")).isEqualTo(21);
        softly.assertThat(XNetAddress.getBitFromSystemName("XS1:1","X")).isEqualTo(1);
        softly.assertThat(XNetAddress.getBitFromSystemName("XS1:2","X")).isEqualTo(2);
        softly.assertThat(XNetAddress.getBitFromSystemName("XL1","X")).isEqualTo(1);
        softly.assertThat(XNetAddress.getBitFromSystemName("XL21","X")).isEqualTo(21);
        softly.assertAll();
    }

    @Test
    void validSystemNameFormat() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(XNetAddress.validSystemNameFormat("XT1",'T',"X")).isEqualTo(Manager.NameValidity.VALID);
        softly.assertThat(XNetAddress.validSystemNameFormat("XT",'T',"X")).isEqualTo(Manager.NameValidity.INVALID);
        JUnitAppender.assertWarnMessage("invalid character in number field of system name: XT");
        softly.assertThat(XNetAddress.validSystemNameFormat("BT1",'T',"X")).isEqualTo(Manager.NameValidity.INVALID);
        JUnitAppender.assertErrorMessage("invalid character in header field of system name: BT1 wants prefix X type T");
        softly.assertAll();
    }

    @Test
    void getUserNameFromSystemName_whenManagersAreNotDefind_ReturnsEmptyString() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(XNetAddress.getUserNameFromSystemName("XT1","X")).isEmpty();
        softly.assertThat(XNetAddress.getUserNameFromSystemName("XS1","X")).isEmpty();
        softly.assertThat(XNetAddress.getUserNameFromSystemName("XL1","X")).isEmpty();
        softly.assertAll();
    }

}
