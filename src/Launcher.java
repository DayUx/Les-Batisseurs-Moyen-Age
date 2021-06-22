import java.util.ArrayList;

import model.Batiment;
import model.Batisseurs;
import model.Machine;
import utilitaire.Input;
import utilitaire.RWFile;
import utilitaire.SubStr;
import view.mainFrame;

public class Launcher {
    public static void main(String[] args) {
        // Batisseurs bat = new Batisseurs();

        System.out.println("#########################################################");
        System.out.println("#  - Bienvenue sur le jeu les Batisseurs : Moyen-Age -  #");
        System.out.println("#   Faites un choix:                                    #");
        System.out.println("#   1. Lancer une partie textuelle                      #");
        System.out.println("#   2. Lancer une sauvegarde de patie textuelle         #");
        System.out.println("#   3. Lancer une partie graphique                      #");
        System.out.println("#   4. Regles                                           #");
        System.out.println("#   5. Quitter                                          #");
        System.out.println("#########################################################");
        int in = 0;
        while (in < 1 || in > 5) {
            in = Input.getInt();
            if (in < 1 || in > 5) {
                System.out.println("Saisie incorrecte");
            }
        }
        if (in == 1) {
            new Batisseurs();
        } else if (in == 2) {
            System.out.println("Saisissez le nom de fichier de la sauvegarde que vous voulez charger");
            String file = Input.getString();
            new Batisseurs(file);
        } else if (in == 3) {
            new mainFrame().setVisible(true);
        } else if (in == 4) {
            ArrayList<String> liste = RWFile.readFile("../data/rules.txt");
            for (String string : liste) {
                System.out.println(string);
            }
            main(null);
        }

        // String test = "Apprenti;2;1;;1;";
        // String res = test.substring(0, test.indexOf(";"));
        // test = test.substring(test.indexOf(";") + 1);
        // System.out.println(Integer.parseInt(""));

    }
}
