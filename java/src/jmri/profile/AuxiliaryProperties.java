// SPDX-License-Identifier: GPL-2.0+
package jmri.profile;

/**
 * JMRI local copy of the NetBeans Platform
 * org.netbeans.spi.project.AuxiliaryProperties.
 *
 * @author Randall Wood
 */
public interface AuxiliaryProperties {

    String get(String key, boolean shared);

    Iterable<String> listKeys(boolean shared);

    void put(String key, String value, boolean shared);
}
