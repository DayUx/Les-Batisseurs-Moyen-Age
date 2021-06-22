package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.buttonBatisseurs;
import view.mainFrame;

public class listenerBatisseurs implements ActionListener {
    private mainFrame frame;

    public listenerBatisseurs(mainFrame frame) {
        if (frame != null) {

        } else {
            System.out.println("listenerBatisseurs : parameter is null");
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("clic");
        if (e.getSource().getClass() == buttonBatisseurs.class) {
            buttonBatisseurs comp = (buttonBatisseurs) e.getSource();

            String str = comp.getText();
            System.out.println(str);

            if (str.equals("Lancer une partie")) {

            } else if (str.equals("Quitter")) {

            } else if (str.equals("Règles")) {

            }
        }
    }

}
