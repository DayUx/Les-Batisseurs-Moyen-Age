package view;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;

public class buttonBatisseurs extends JButton {
    private String titre;

    public buttonBatisseurs(String titre) {
        if (titre != null) {
            this.titre = titre;
            this.initComponents();
        } else {
            System.out.println();
        }
    }

    /**
     * Initializes the button
     */
    public void initComponents() {
        this.setFont(new Font("Arial", Font.PLAIN, 40));
        setText(this.titre);
        this.setBackground(Color.BLACK);
        this.setForeground(new Color(255, 255, 255));
        Border border = new LineBorder(Color.WHITE, 5);

        this.setBorder(border);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setVisible(true);

    }
}
