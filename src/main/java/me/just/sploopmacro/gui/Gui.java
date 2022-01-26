package me.just.sploopmacro.gui;

import me.just.sploopmacro.SploopMacro;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Gui extends JFrame {
    private JSlider loopSlider;
    private JSlider placeSlider;

    private JLabel loopLabel;
    private JLabel placeLabel;


    public boolean guiOpen = true;

    public int loopTickDel = 25;
    public int placeDel = 10;

    private static final String LOOP_TICK_DISP = "Loop tick delay: ";
    private static final String PLACE_DELAY_DISP = "Object place delay: ";

    public Gui(){
        setLayout(new FlowLayout());

        JPanel panelInfo = new JPanel();
        panelInfo.add(new JLabel("All settings are in milliseconds"));
        add(panelInfo);

        setupLoopSlider();

        setupPlaceSlider();

        initGui();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                dispose();
                guiOpen = false;
                if(SploopMacro.checker.outDated){
                    SploopMacro.checker.browsePage();
                }
            }
        });
    }

    private void setupPlaceSlider(){
        JPanel placePanel = new JPanel();
        placePanel.setLayout(new FlowLayout());

        placeSlider = new JSlider(JSlider.HORIZONTAL, 0, 25, 10);
        placeSlider.setMajorTickSpacing(10);
        placeSlider.setPaintTicks(true);
        placePanel.add(placeSlider);

        placeSlider.addChangeListener(new PlaceDelListener());

        placeLabel = new JLabel(PLACE_DELAY_DISP + placeDel);
        placePanel.add(placeLabel);

        add(placePanel);
    }

    private void setupLoopSlider(){
        JPanel loopTickPanel = new JPanel();
        loopTickPanel.setLayout(new FlowLayout());

        loopSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
        loopSlider.setMajorTickSpacing(10);
        loopSlider.setPaintTicks(true);
        loopTickPanel.add(loopSlider);

        loopSlider.addChangeListener(new LoopTickDelListener());

        loopLabel = new JLabel(LOOP_TICK_DISP + loopTickDel);
        loopTickPanel.add(loopLabel);

        add(loopTickPanel);
    }

    private void initGui(){
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(400, 250);
        setLocation(400, 300);
        setIconImage(new ImageIcon(ClassLoader.getSystemResource("img/sploop.png")).getImage());
        setVisible(true);
        setTitle("SploopHack v2");
        if(SploopMacro.checker.outDated) {
            System.out.println("client outdated, prompting");

            JOptionPane.showMessageDialog(null, "SploopHack v2 is outdated!\nClose out to open releases page", "SploopHack Updater", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class LoopTickDelListener implements ChangeListener {
        public void stateChanged(ChangeEvent e){
            int value = loopSlider.getValue();
            loopTickDel = value;
            loopLabel.setText(LOOP_TICK_DISP + value);
        }
    }

    private class PlaceDelListener implements ChangeListener {
        public void stateChanged(ChangeEvent e){
            int value = placeSlider.getValue();
            placeDel = value;
            placeLabel.setText(PLACE_DELAY_DISP + value);
        }
    }
}
