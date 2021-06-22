package view;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainPanel extends JPanel {
    JButton regles, lancer, quitter;
    mainFrame frame;

    public mainPanel(mainFrame frame) {

        if (frame != null) {
            this.frame = frame;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            initialize();

            this.setOpaque(false);
            setVisible(true);
        } else {
            System.out.println("mainPanel : parameter is null");
        }

    }

    public void initialize() {
        lancer = new buttonBatisseurs("Lancer une partie");
        lancer.setAlignmentX(Component.CENTER_ALIGNMENT);
        lancer.addActionListener(this.frame.getActionListener());

        regles = new buttonBatisseurs("R\u00e8gles");
        regles.setAlignmentX(Component.CENTER_ALIGNMENT);
        regles.addActionListener(this.frame.getActionListener());

        quitter = new buttonBatisseurs("Quitter");
        quitter.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitter.addActionListener(this.frame.getActionListener());
        try {
            JLabel image = new JLabel(new ImageIcon(ImageIO.read(new File("../data/img/logo.png"))));
            image.setAlignmentX(Component.CENTER_ALIGNMENT);

            add(Box.createVerticalGlue());
            add(image);
        } catch (IOException e) {
            System.err.println(e);
        }
        add(Box.createVerticalGlue());
        this.add(lancer);
        add(Box.createVerticalGlue());
        this.add(regles);
        add(Box.createVerticalGlue());
        this.add(quitter);
        add(Box.createVerticalGlue());

    }
}
