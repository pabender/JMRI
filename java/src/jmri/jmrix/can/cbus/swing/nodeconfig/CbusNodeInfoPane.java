package jmri.jmrix.can.cbus.swing.nodeconfig;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import jmri.jmrix.can.cbus.node.CbusNode;
import jmri.jmrix.can.cbus.node.CbusNodeConstants;
import jmri.jmrix.can.cbus.node.CbusNodeParameterManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Steve Young Copyright (C) 2018
 */
public class CbusNodeInfoPane extends JPanel implements PropertyChangeListener {
    
    private JPanel infoPane;
    private final JButton nodesupportlinkbutton;
    private URI supportlink;
    private CbusNode nodeOfInterest;
    private JLabel header;
    private JPanel menuPane;
    private JTextArea textArea;
    private CbusNodeParameterManager paramMgr;

    /**
     * Create a new instance of CbusNodeInfoPane.
     */
    public CbusNodeInfoPane() {
        super();
        
        nodesupportlinkbutton = new JButton();
        nodesupportlinkbutton.addActionListener((ActionEvent e) -> {
            openUri(supportlink);
        });
        
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent ev){
        paramsHaveUpdated();
    }
    
    private boolean proceedCreatePanel(CbusNode node) {

        if ( node == null ){
            if (infoPane != null ){ 
                infoPane.setVisible(false);
            }
            return false;
        }
        if ( node == nodeOfInterest ){
            return false;
        }
        if ( nodeOfInterest != null ) {
            node.removePropertyChangeListener(this);
        }
        
        node.addPropertyChangeListener(this);
        nodeOfInterest = node;
        paramMgr = node.getNodeParamManager();
        return true;
}
    
    /**
     * Initialise the pane for a particular CbusNode ( or CbusBackupNode )
     * @param node the node to display info for
     */
    public void initComponents(CbusNode node) {
        
        if (!proceedCreatePanel(node)){
            return;
        }
        
        menuPane = new JPanel();
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setMargin( new java.awt.Insets(10,10,10,10) );
        JScrollPane textAreaPanel = new JScrollPane(textArea);
        
        header = new JLabel("");
        menuPane.add(header);
        menuPane.add(nodesupportlinkbutton);
        
        this.setLayout(new BorderLayout() );
        
        // sets the text area text and support link button etc.
        paramsHaveUpdated();
        
        if (infoPane != null ){ 
            infoPane.setVisible(false);
        }
        infoPane = null;
        infoPane = new JPanel();
        infoPane.setLayout(new BorderLayout() );
        
        infoPane.add(menuPane, BorderLayout.PAGE_START);
        infoPane.add(textAreaPanel, BorderLayout.CENTER);
        this.add(infoPane);
        validate();
        repaint();
        
    }
    
    private void appendIfKnown( StringBuilder sb, int paramToCheck, String label ){
        if (paramMgr.getParameter(paramToCheck) > -1) {
                appendRaw(sb,paramMgr.getParameter(paramToCheck),label);
        }
    }
    
    private void appendRaw( StringBuilder sb, Object value, String label ){
        sb.append (label).append (" : ").append (value).append(System.getProperty("line.separator"));
    }
    
    private void setHeaderText() {
        StringBuilder buildheader = new StringBuilder();
        buildheader.append("<html><h3>");
        buildheader.append(CbusNodeConstants.getManu(paramMgr.getParameter(1)));
        buildheader.append(" ");
        buildheader.append(nodeOfInterest.getNodeStats().getNodeTypeName());
        buildheader.append("</h3></html>");
        header.setText(buildheader.toString());
    }
    
    /**
     * Recalculates pane following notification from CbusNode that parameters have changed
     */
    public void paramsHaveUpdated() {
        
        updateSupportButton();
                
        setHeaderText();
        
        StringBuilder textAreaString = new StringBuilder();
        
        appendRaw(textAreaString,nodeOfInterest.getNodeNumber(),Bundle.getMessage("NodeNumberTitle"));
        
        appendNodeTypeInfo(textAreaString);
        
        appendIfKnown(textAreaString, paramMgr.getParameter(6), Bundle.getMessage("NodeVariables"));
        
        appendIfKnown(textAreaString, paramMgr.getParameter(0), "Parameters");
        
        if ( nodeOfInterest.getNodeEventManager().getTotalNodeEvents()> -1 ) {
            appendRaw(textAreaString,nodeOfInterest.getNodeEventManager()
                .getTotalNodeEvents(), "Current Events");
        }

        appendIfKnown(textAreaString, paramMgr.getParameter(4), "Max Events");
        appendIfKnown(textAreaString, paramMgr.getParameter(5), "Max Event Variables per Event");
        
        if ((paramMgr.getParameter(0)>9) && (paramMgr.getParameter(10)>0)) {           
            textAreaString.append (CbusNodeConstants.getBusType(paramMgr.getParameter(10)));
            textAreaString.append (" ");
            textAreaString.append (Bundle.getMessage("BusType"));
            textAreaString.append(System.getProperty("line.separator"));
        }
        
        appendRaw(textAreaString, Math.max(0,nodeOfInterest.getNodeStats()
            .totalNodeBytes()), "Current Node Data Bytes");
        
        addBackupInfo(textAreaString);
        
        appendRaw(textAreaString, nodeOfInterest.getsendsWRACKonNVSET(), "Sends WRACK Following NV Set");
        
        appendAllParams(textAreaString);
        
        //   nodePartTwobuilder.append ("<p> Is Bootable Y / N</p>");
        //   nodePartTwobuilder.append ("<p> Processor : </p>");
        //   nodePartTwobuilder.append ("<p> Flags </p>");
        
        textArea.setText(textAreaString.toString());
        textArea.setCaretPosition(0);
        
    }
    
    private void appendNodeTypeInfo(StringBuilder sb) {
    
        if (paramMgr.getParameter(1) > -1 && 
            paramMgr.getParameter(3) > -1 ) {
        
            sb.append(Bundle.getMessage("ManufacturerType",
                paramMgr.getParameter(1),
                CbusNodeConstants.getManu(paramMgr.getParameter(1)),
                paramMgr.getParameter(3)));
                
            sb.append(System.getProperty("line.separator"));
        
        }
        
        if (!nodeOfInterest.getNodeStats().getNodeTypeName().isEmpty()){
            sb.append(Bundle.getMessage("IdentifiesAs",
                nodeOfInterest.getNodeStats().getNodeTypeName(),
                CbusNodeConstants.getModuleTypeExtra(
                    paramMgr.getParameter(1),
                    paramMgr.getParameter(3)))
            );
            sb.append(System.getProperty("line.separator"));
        }
        
        appendFirmware(sb);
        
    }
    
    private void appendFirmware(StringBuilder sb) {
    
        if ((paramMgr.getParameter(2)>0) && 
            (paramMgr.getParameter(7)>0)) {
            sb.append (Bundle.getMessage("FirmwareVer",
                paramMgr.getParameter(7),
                Character.toString((char) paramMgr.getParameter(2))));
            
            if ((paramMgr.getParameter(0)>19) && (paramMgr.getParameter(20)>0) ){
                sb.append (Bundle.getMessage("FWBeta")); 
                sb.append (paramMgr.getParameter(20));
            }
            sb.append(System.getProperty("line.separator"));
        }
    }
    
    
    private void addBackupInfo(StringBuilder sb) {
        
        sb.append(System.getProperty("line.separator"));
        
        appendRaw(sb, nodeOfInterest.getNodeBackupManager()
            .getBackups().size(), "Entries in Node xml file");
        
        appendRaw(sb, nodeOfInterest.getNodeBackupManager()
            .getNumCompleteBackups(), "Num Backups in Node xml file");
        
        if( nodeOfInterest.getNodeBackupManager().getNumCompleteBackups()>0 ) {
        appendRaw(sb, nodeOfInterest.getNodeBackupManager().getFirstBackupTime(), "First entry");
        appendRaw(sb, nodeOfInterest.getNodeBackupManager().getLastBackupTime(), "Last entry");
        }
    }
    
    private void appendAllParams(StringBuilder sb) {
        
        if (!paramMgr.getParameterHexString().isEmpty()) {
            sb.append(System.getProperty("line.separator"));
            sb.append ("Parameter Hex String : ");
            sb.append (paramMgr.getParameterHexString());
            sb.append(System.getProperty("line.separator"));
        }
        
        
        sb.append(System.getProperty("line.separator"));
        for (int i = 1; i <= paramMgr.getParameter(0); i++) {
            if ( paramMgr.getParameter(i) > -1 ) {
                sb.append ("Parameter ");
                sb.append (i);
                sb.append (" : ");
                sb.append ( paramMgr.getParameter(i) );
                sb.append (" (dec)");
                sb.append(System.getProperty("line.separator"));
            }
        }
    }
    
    private void updateSupportButton() {
    
        String supportLinkStr = CbusNodeConstants.getModuleSupportLink(paramMgr.getParameter(1),paramMgr.getParameter(3));
        
        if ( !supportLinkStr.isEmpty() ) {
            nodesupportlinkbutton.setText(supportLinkStr);

            nodesupportlinkbutton.setToolTipText("<html>" + CbusNodeConstants.getManu(paramMgr.getParameter(1)) + 
                " " + CbusNodeConstants.getModuleType(paramMgr.getParameter(1),paramMgr.getParameter(3)) + 
                " " + Bundle.getMessage("Support") + "</html>");            

            try {
                supportlink=new URI(supportLinkStr);
                nodesupportlinkbutton.setVisible(true);
                return;
            } 
            catch (URISyntaxException ex) {
                log.warn("Unable to create support link URI for module type {} {}", paramMgr.getParameter(3), ex);
            }
            
        } 
        nodesupportlinkbutton.setVisible(false);
        
    }
    
    private static void openUri(URI uri) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(uri);
            } catch (IOException e) {
                log.warn("Unable to get URI for {} {}", uri, e);
            }
        }
    }
    
    private final static Logger log = LoggerFactory.getLogger(CbusNodeInfoPane.class);
    
}
