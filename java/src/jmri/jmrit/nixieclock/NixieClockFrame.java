// SPDX-License-Identifier: GPL-2.0+
package jmri.jmrit.nixieclock;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import jmri.InstanceManager;
import jmri.Timebase;
import jmri.jmrit.catalog.NamedIcon;
import jmri.util.JmriJFrame;

/**
 * Frame providing a simple clock showing Nixie tubes.
 * <p>
 * A Run/Stop button is built into this, but because I don't like the way it
 * looks, it's not currently displayed in the GUI.
 *
 * Modified by Dennis Miller for resizing Nov, 2004
 *
 * @author Bob Jacobsen Copyright (C) 2001
 */
public class NixieClockFrame extends JmriJFrame implements java.beans.PropertyChangeListener {

    // GUI member declarations
    JLabel h1;  // msb of hours
    JLabel h2;
    JLabel m1;  // msb of minutes
    JLabel m2;
    JLabel colon;

    double aspect;
    double iconAspect;

    Timebase clock;

    NamedIcon tubes[] = new NamedIcon[10];
    NamedIcon baseTubes[] = new NamedIcon[10];
    NamedIcon colonIcon;
    NamedIcon baseColon;
    //"base" variables used to hold original gifs, other variables used with scaled images

    public NixieClockFrame() {
        super(Bundle.getMessage("MenuItemNixieClock"));

        clock = InstanceManager.getDefault(jmri.Timebase.class);

        //Load the images (these are now the larger version of the original gifs
        for (int i = 0; i < 10; i++) {
            baseTubes[i] = new NamedIcon("resources/icons/misc/Nixie/M" + i + "B.gif", "resources/icons/misc/Nixie/M" + i + "B.gif");
            tubes[i] = new NamedIcon("resources/icons/misc/Nixie/M" + i + "B.gif", "resources/icons/misc/Nixie/M" + i + "B.gif");
        }
        colonIcon = new NamedIcon("resources/icons/misc/Nixie/colonB.gif", "resources/icons/misc/Nixie/colonB.gif");
        baseColon = new NamedIcon("resources/icons/misc/Nixie/colonB.gif", "resources/icons/misc/Nixie/colonB.gif");
        // set initial size the same as the original gifs
        for (int i = 0; i < 10; i++) {
            Image scaledImage = baseTubes[i].getImage().getScaledInstance(23, 32, Image.SCALE_SMOOTH);
            tubes[i].setImage(scaledImage);
        }
        Image scaledImage = baseColon.getImage().getScaledInstance(12, 32, Image.SCALE_SMOOTH);
        colonIcon.setImage(scaledImage);

        // determine aspect ratio of a single digit graphic
        iconAspect = 24. / 32.;

        // determine the aspect ratio of the 4 digit base graphic plus a half digit for the colon
        // this DOES NOT allow space for the Run/Stop button, if it is
        // enabled.  When the Run/Stop button is enabled, the layout will have to be changed
        if (!clock.getShowStopButton()) {
            aspect = (4.5 * 24.) / 32.; // pick up clock prefs choice: no button
        } else {
            aspect = (4.5 * 24. + 20.) / 32.; // pick up clock prefs choice: add 20. for a stop/start button
        }

        // listen for changes to the Timebase parameters
        clock.addPropertyChangeListener(this);

        // init GUI
        m1 = new JLabel(tubes[0]);
        m2 = new JLabel(tubes[0]);
        h1 = new JLabel(tubes[0]);
        h2 = new JLabel(tubes[0]);
        colon = new JLabel(colonIcon);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        getContentPane().add(h1);
        getContentPane().add(h2);
        getContentPane().add(colon);
        getContentPane().add(m1);
        getContentPane().add(m2);

        getContentPane().add(b = new JButton(Bundle.getMessage("ButtonPauseClock")));
        b.addActionListener(new ButtonListener());
        // since Run/Stop button looks crummy, user may turn it on in clock prefs
        b.setVisible(clock.getShowStopButton()); // pick up clock prefs choice
        updateButtonText();
        update();
        pack();

        // request callback to update time
        clock.addMinuteChangeListener((java.beans.PropertyChangeEvent e) -> {
            update();
        });

        // Add component listener to handle frame resizing event
        this.addComponentListener(
                new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        scaleImage();
                    }
                });

    }

    // Added method to scale the clock digit images to fit the
    // size of the display window
    public void scaleImage() {
        int iconHeight;
        int iconWidth;
        int frameHeight = this.getContentPane().getSize().height;
        int frameWidth = this.getContentPane().getSize().width;
        if ((double) frameWidth / (double) frameHeight > aspect) {
            iconHeight = frameHeight;
            iconWidth = (int) (iconAspect * iconHeight);
        } else {
            // this DOES NOT allow space for the Run/Stop button, if it is enabled.
            // When the Run/Stop button is enabled, the layout will change accordingly.
            iconWidth = (int) (frameWidth / 4.5);
            iconHeight = (int) (iconWidth / iconAspect);
        }
        for (int i = 0; i < 10; i++) {
            Image scaledImage = baseTubes[i].getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
            tubes[i].setImage(scaledImage);
        }
        Image scaledImage = baseColon.getImage().getScaledInstance(iconWidth / 2, iconHeight, Image.SCALE_SMOOTH);
        colonIcon.setImage(scaledImage);
        // update the images on screen
        this.getContentPane().revalidate();
    }

    @SuppressWarnings("deprecation")
    void update() {
        Date now = clock.getTime();
        int hours = now.getHours();
        int minutes = now.getMinutes();

        h1.setIcon(tubes[hours / 10]);
        h2.setIcon(tubes[hours - (hours / 10) * 10]);
        m1.setIcon(tubes[minutes / 10]);
        m2.setIcon(tubes[minutes - (minutes / 10) * 10]);
    }

        /**
     * Handle a change to clock properties.
     * @param e unused.
     */
    @Override
    public void propertyChange(java.beans.PropertyChangeEvent e) {
        updateButtonText();
    }
    
    /**
     * Update clock button text.
     */
    private void updateButtonText(){
        b.setText( Bundle.getMessage( clock.getRun() ? "ButtonPauseClock" : "ButtonRunClock") );
    }

    JButton b;

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            clock.setRun(!clock.getRun());
            updateButtonText();
        }
    }
    
}
