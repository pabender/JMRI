package jmri.jmrit.whereused;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.SortedSet;
import javax.swing.JTextArea;

import jmri.*;
import jmri.jmrit.blockboss.BlockBossLogic;
import jmri.jmrit.logix.OBlockManager;
import jmri.jmrit.display.layoutEditor.LayoutBlockManager;
/**
 * Find references.  Each collector method calls a corresponding getUsageReport(NamedBean)
 * in the main implementation class for the object type.  The matches are returned in an
 * array list of NamedBeanUsageReport objects.
 *
 * Collectors:
 * <ul>
 * <li>checkTurnouts - Feedback sensors</li>
 * <li>checkLights - Light control sensors and turnouts</li>
 * <li>checkRoutes - Route definitions</li>
 * <li>checkBlocks - Occupancy sensors</li>
 * <li>checkLayoutBlocks - Occupancy sensors</li>
 * <li>checkSignalHeads - SSL definitions</li>
 * <li>checkSignalMasts - SML definitions</li>
 * <li>checkSignalGroups - Signal mast, signal heads, sensors and turnouts</li>
 * <li>checkOBlocks</li>
 * <li>checkLogixConditionals</li>
 * <li>checkSections - Direction and Stopping sensors</li>
 * <li>checkTransits - Stop Allocation and Action sensors</li>
 * <li>checkPanels - Sensor icons</li>
 * <li>CTC - OS sensors TODO</li>
 * </ul>
 *
 * @author Dave Sand Copyright (C) 2020
 */

public class WhereUsedCollectors {

    /**
     * Create the Turnout usage string.
     * Usage keys:
     * <ul>
     * <li>TurnoutFeedback1</li>
     * <li>TurnoutFeedback2</li>
     * </ul>
     * @param bean The requesting bean:  Sensor.
     * @return usage string
     */
    static String checkTurnouts(NamedBean bean) {
        StringBuilder sb = new StringBuilder();
        InstanceManager.getDefault(TurnoutManager.class).getNamedBeanSet().forEach((turnout) -> {
            int feedback = turnout.getFeedbackMode();
            if (feedback == Turnout.ONESENSOR || feedback == Turnout.TWOSENSOR) {
                turnout.getUsageReport(bean).forEach((report) -> {
                    if (report.usageKey.startsWith("TurnoutFeedback")) {
                        sb.append(Bundle.getMessage("ReferenceLine", turnout.getUserName(), turnout.getSystemName()));  // NOI18N
                    }
                });
            }
        });
        return addHeader(sb, "ReferenceFeedback");
    }

    /**
     * Create the Light usage string.
     * Usage keys:
     * <ul>
     * <li>LightControlSensor1</li>
     * <li>LightControlSensor2</li>
     * <li>LightControlSensorTimed</li>
     * <li>LightControlTurnout</li>
     * </ul>
     * @param bean The requesting bean:  Sensor, Turnout.
     * @return usage string
     */
    static String checkLights(NamedBean bean) {
        StringBuilder sb = new StringBuilder();
        InstanceManager.getDefault(LightManager.class).getNamedBeanSet().forEach((light) -> {
            light.getUsageReport(bean).forEach((report) -> {
                if (report.usageKey.startsWith("LightControl")) {
                    sb.append(Bundle.getMessage("ReferenceLineData", light.getUserName(), light.getSystemName(), report.usageData));  // NOI18N
                }
            });
        });
        return addHeader(sb, "ReferenceLightControl");  // NOI18N
    }

    /**
     * Create the Route usage string.
     * Usage keys:
     * <ul>
     * <li>RouteTurnoutOutput</li>
     * <li>RouteSensorOutput</li>
     * <li>RouteSensorControl</li>
     * <li>RouteSensorAligned</li>
     * <li>RouteTurnoutControl</li>
     * <li>RouteTurnoutLock</li>
     * </ul>
     * @param bean The requesting bean:  Sensor, Turnout.
     * @return usage string
     */
    static String checkRoutes(NamedBean bean) {
        StringBuilder sb = new StringBuilder();
        InstanceManager.getDefault(RouteManager.class).getNamedBeanSet().forEach((route) -> {
            route.getUsageReport(bean).forEach((report) -> {
                if (report.usageKey.startsWith("Route")) {
                    sb.append(Bundle.getMessage("ReferenceLine", route.getUserName(), route.getSystemName()));  // NOI18N
                }
            });
        });
        return addHeader(sb, "ReferenceRoutes");  // NOI18N
    }

    /**
     * Create the Block usage string.
     * Usage keys:
     * <ul>
     * <li>BlockSensor</li>
     * <li>BlockReporter</li>
     * <li>BlockPathTurnout</li>
     * </ul>
     * @param bean The requesting bean:  Sensor, Reporter, Turnout (paths).
     * @return usage string
     */
    static String checkBlocks(NamedBean bean) {
        StringBuilder sb = new StringBuilder();
        InstanceManager.getDefault(BlockManager.class).getNamedBeanSet().forEach((block) -> {
            block.getUsageReport(bean).forEach((report) -> {
                if (report.usageKey.startsWith("Block")) {
                    sb.append(Bundle.getMessage("ReferenceLine", block.getUserName(), block.getSystemName()));  // NOI18N
                }
            });
        });
        return addHeader(sb, "ReferenceBlockOccupancy");  // NOI18N
    }

    /**
     * Create the LayoutBlock usage string.
     * Usage keys:
     * <ul>
     * <li>LayoutBlockBlock</li>
     * <li>LayoutBlockMemory</li>
     * <li>LayoutBlockSensor</li>
     * </ul>
     * @param bean The requesting bean:  Block, Memory, Sensor.
     * @return usage string
     */
    static String checkLayoutBlocks(NamedBean bean) {
        StringBuilder sb = new StringBuilder();
        InstanceManager.getDefault(LayoutBlockManager.class).getNamedBeanSet().forEach((layoutBlock) -> {
            layoutBlock.getUsageReport(bean).forEach((report) -> {
                if (report.usageKey.startsWith("LayoutBlock")) {
                    sb.append(Bundle.getMessage("ReferenceLine", layoutBlock.getUserName(), layoutBlock.getSystemName()));  // NOI18N
                }
            });
        });
        return addHeader(sb, "ReferenceLayoutBlockOccupancy");  // NOI18N
    }

    /**
     * Create the Signal Head Logic usage string.
     * Usage keys:
     * <ul>
     * <li>SSLSignal</li>
     * <li>SSLSensor1-5</li>
     * <li>SSLTurnout</li>
     * <li>SSLSignal1</li>
     * <li>SSLSignal1Alt</li>
     * <li>SSLSignal2</li>
     * <li>SSLSignal2Alt</li>
     * <li>SSLSensorWatched1</li>
     * <li>SSLSensorWatched1Alt</li>
     * <li>SSLSensorWatched2</li>
     * <li>SSLSensorWatched2Alt</li>
     * <li>SSLSensorApproach</li>
     * </ul>
     * @param bean The requesting bean:  Sensor, Signal Head, Turnout.
     * @return usage string
     */
    static String checkSignalHeadLogic(NamedBean bean) {
        StringBuilder sb = new StringBuilder();
        Enumeration<BlockBossLogic> e = BlockBossLogic.entries();
        while (e.hasMoreElements()) {
            BlockBossLogic ssl = e.nextElement();
            ssl.getUsageReport(bean).forEach((report) -> {
                if (report.usageKey.startsWith("SSL")) {  // NOI18N
                    sb.append(Bundle.getMessage("ReferenceLine", report.usageBean.getUserName(), report.usageBean.getSystemName()));  // NOI18N
                }
            });
        }
        return addHeader(sb, "ReferenceHeadSSL");  // NOI18N
    }

    /**
     * Create the Signal Mast Logic usage string.
     * Usage keys:
     * <ul>
     * <li>SMLBlockAuto</li>
     * <li>SMLBlockUser</li>
     * <li>SMLTurnoutAuto</li>
     * <li>SMLTurnoutUser</li>
     * <li>SMLSensor</li>
     * <li>SMLMastAuto</li>
     * <li>SMLMastUser</li>
     * </ul>
     * @param bean The requesting bean:  Block, Turnout, Sensor, Signal Mast.
     * @return usage string
     */
    static String checkSignalMastLogic(NamedBean bean) {
        StringBuilder sb = new StringBuilder();
        InstanceManager.getDefault(SignalMastLogicManager.class).getNamedBeanSet().forEach((sml) -> {
            sml.getUsageReport(bean).forEach((report) -> {
                if (report.usageKey.startsWith("SML")) {
                    sb.append(Bundle.getMessage("ReferenceLinePair", sml.getSourceMast().getDisplayName(), report.usageBean.getDisplayName()));  // NOI18N
                }
            });
        });
        return addHeader(sb, "ReferenceMastSML");  // NOI18N
    }

    /**
     * Create the Signal Group usage string.
     * Usage keys:
     * <ul>
     * <li>SignalGroupMast</li>
     * <li>SignalGroupHead</li>
     * <li>SignalGroupHeadSensor</li>
     * <li>SignalGroupHeadTurnout</li>
     * </ul>
     * @param bean The requesting bean:  Sensor, Signal Head, Signal Mast, Turnout.
     * @return usage string
     */
    static String checkSignalGroup(NamedBean bean) {
        StringBuilder sb = new StringBuilder();
        InstanceManager.getDefault(SignalGroupManager.class).getNamedBeanSet().forEach((group) -> {
            group.getUsageReport(bean).forEach((report) -> {
                if (report.usageKey.startsWith("SignalGroup")) {
                    sb.append(Bundle.getMessage("ReferenceLine", group.getUserName(), group.getSystemName()));  // NOI18N
                }
            });
        });
        return addHeader(sb, "ReferenceSignalGroup");  // NOI18N
    }

    /**
     * Create the OBlock usage string.
     * Usage keys:
     * <ul>
     * <li>OBlockSensor</li>
     * <li>OBlockSensorError</li>
     * <li>OBlockReporter</li>
     * <li>OBlockPathTurnout</li>
     * <li>OBlockPortalFromSignal</li>
     * <li>OBlockPortalToSignal</li>
     * </ul>
     * @param bean The requesting bean:  Sensor, SignalHead, SignalMast, Reporter, Turnout.
     * @return usage string
     */
    static String checkOBlocks(NamedBean bean) {
        StringBuilder sb = new StringBuilder();
        InstanceManager.getDefault(OBlockManager.class).getNamedBeanSet().forEach((oblock) -> {
            oblock.getUsageReport(bean).forEach((report) -> {
                if (report.usageKey.startsWith("OBlock")) {
                    sb.append(Bundle.getMessage("ReferenceLine", oblock.getUserName(), oblock.getSystemName()));  // NOI18N
                }
            });
        });
        return addHeader(sb, "ReferenceOBlockOccupancy");  // NOI18N
    }

    /**
     * Create the Logix/Conditional usage string.
     * Usage keys:
     * <ul>
     * <li>ConditionalAction</li>
     * <li>ConditionalVariable</li>
     * <li>ConditionalVariableData</li>
     * </ul>
     * @param bean The requesting bean:  Many.
     * @return usage string
     */
    static String checkLogixConditionals(NamedBean bean) {
        StringBuilder sb = new StringBuilder();
        InstanceManager.getDefault(LogixManager.class).getNamedBeanSet().forEach((logix) -> {
            logix.getUsageReport(bean).forEach((report) -> {
                if (report.usageKey.startsWith("ConditionalVariable") || report.usageKey.startsWith("ConditionalAction")) {  // NOI18N
                    sb.append(Bundle.getMessage("ReferenceLineConditional", logix.getUserName(), logix.getSystemName(),  // NOI18N
                            report.usageData));
                }
            });
        });
        return addHeader(sb, "ReferenceConditionals");  // NOI18N
    }

    /**
     * Create the Section usage string.
     * Usage keys:
     * <ul>
     * <li>SectionSensorForwardBlocking</li>
     * <li>SectionSensorForwardStopping</li>
     * <li>SectionSensorReverseBlocking</li>
     * <li>SectionSensorReverseStopping</li>
     * </ul>
     * @param bean The requesting bean:  Many.
     * @return usage string
     */
    static String checkSections(NamedBean bean) {
        StringBuilder sb = new StringBuilder();
        InstanceManager.getDefault(SectionManager.class).getNamedBeanSet().forEach((section) -> {
            section.getUsageReport(bean).forEach((report) -> {
                if (report.usageKey.startsWith("SectionSensor")) {
                    sb.append(Bundle.getMessage("ReferenceLine", section.getUserName(), section.getSystemName()));  // NOI18N
                }
            });
        });
        return addHeader(sb, "ReferenceSections");  // NOI18N
    }

    /**
     * Create the Transit usage string.
     * Usage keys:
     * <ul>
     * <li>TransitSensorStopAllocation</li>
     * <li>TransitActionSensorWhen</li>
     * <li>TransitActionSensorWhat</li>
     * <li>TransitActionSignalHeadWhat</li>
     * <li>TransitActionSignalMastWhat</li>
     * </ul>
     * @param bean The requesting bean:  Sensor, Signal Head, Signal Mast.
     * @return usage string
     */
    static String checkTransits(NamedBean bean) {
        StringBuilder sb = new StringBuilder();
        InstanceManager.getDefault(TransitManager.class).getNamedBeanSet().forEach((transit) -> {
            transit.getUsageReport(bean).forEach((report) -> {
                if (report.usageKey.startsWith("TransitSensorStop")) {  // NOI18N
                    sb.append(Bundle.getMessage("ReferenceLine", transit.getUserName(), transit.getSystemName()));  // NOI18N
                }
                if (report.usageKey.startsWith("TransitAction")) {  // NOI18N
                    sb.append(Bundle.getMessage("ReferenceLineAction", transit.getUserName(), transit.getSystemName(),  // NOI18N
                            report.usageBean.getDisplayName()));
                }
            });
        });
        return addHeader(sb, "ReferenceTransits");  // NOI18N
    }

    /**
     * Create the Panel usage string.  The string includes the icon class name.
     * Usage keys:
     * <ul>
     * <li>PositionalIcon</li>
     * <li>LayoutEditorTurnout</li>
     * <li>LayoutEditorTurnout2</li>
     * </ul>
     * Note:  The getUsageReport is invoked at either Editor or LayoutEditor depending on the
     * panel type.  The LayoutEditor version does a super call and then does special turnout
     * checking since LE turnouts are not icons.
     * @param bean The requesting bean:  Many.
     * @return usage string
     */
    static String checkPanels(NamedBean bean) {
        StringBuilder sb = new StringBuilder();
        InstanceManager.getDefault(jmri.jmrit.display.EditorManager.class).getEditorsList().forEach((panel) -> {
            panel.getUsageReport(bean).forEach((report) -> {
                sb.append(Bundle.getMessage("ReferenceLineData2", panel.getTitle(), report.usageData));  // NOI18N
            });
        });
        return addHeader(sb, "ReferencePanels");  // NOI18N
    }

    /**
     * Create the CTC usage string.
     * Usage keys:  None yet.
     * @param bean The requesting bean:  Block, Sensor, Signal Head, Signal Mast, Turnout.
     * @return usage string
     */
    static String checkCTC(NamedBean bean) {
        log.debug("CTC process pending: bean = {}", bean);
        return "";
    }

    /**
     * Add the specified section to the beginning of the string builder if there is data.
     * @param sb The current string builder.
     * @param bundleKey The key for the section header.
     * @return the resulting string.
     */
    static String addHeader(StringBuilder sb, String bundleKey) {
        if (sb.length() > 0) {
            sb.insert(0, Bundle.getMessage("ReferenceHeader", Bundle.getMessage(bundleKey)));  // NOI18N
            sb.append("\n");
        }
        return sb.toString();
    }

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(WhereUsedCollectors.class);
}
