// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.jmrix.mqtt;

/**
 *
 * @author Lionel Jeanson
 */
public interface MqttEventListener extends java.util.EventListener {
     public void notifyMqttMessage(String topic, String message);
     
}
