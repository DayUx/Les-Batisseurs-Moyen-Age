package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.listenerBatisseurs;

public class mainFrame extends JFrame {
    private JPanel mainPanel;
    private ActionListener actionListener;

    public mainFrame() {
        this.actionListener = new listenerBatisseurs(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1024, 720));
        setTitle("LesBatisseurs");

        initComponents();
        pack();
        setLocationRelativeTo(null);

    }

    public void initComponents() {
        try {
            JLabel bg = new JLabel(new ImageIcon(ImageIO.read(new File("../data/img/background.jpg"))));

            this.mainPanel = new mainPanel(this);
            bg.setLayout(new BorderLayout());

            bg.add(this.mainPanel);
            this.add(bg);

            // this.add(new receptionBibliGo());
            // this.add(new commanderBibligo());

            // this.add(new panelConnexion());
        } catch (Exception e) {
            System.err.println(e);
        }

    };

    public ActionListener getActionListener() {
        return actionListener;
    }

    /**
     * Changes the current panel
     */
    public void setPanel(JPanel panel) {
        this.remove(this.mainPanel);
        this.mainPanel = panel;
        add(this.mainPanel);
        this.revalidate();
        this.repaint();
    }

}
