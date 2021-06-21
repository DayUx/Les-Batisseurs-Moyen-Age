import model.Batiment;
import model.Batisseurs;
import model.Machine;
import utilitaire.Input;
import utilitaire.SubStr;

public class Launcher {
    public static void main(String[] args) {
        // Batisseurs bat = new Batisseurs();

        System.out.println("#########################################################");
        System.out.println("#  - Bienvenue sur le jeu les Batisseurs : Moyen-Age -  #");
        System.out.println("#   Faites un choix:                                    #");
        System.out.println("#   1. Lancer une partie                                #");
        System.out.println("#   2. Regles                                           #");
        System.out.println("#   3. Quitter                                          #");
        System.out.println("#########################################################");
        int in = 0;
        while (in < 1 || in > 3) {
            in = Input.getInt();
            if (in < 1 || in > 3) {
                System.out.println("Saisie incorrecte");
            }
        }
        if (in == 1) {
            new Batisseurs();
        } else if (in == 2) {
            System.out.println();
        }

        // String test = "Apprenti;2;1;;1;";
        // String res = test.substring(0, test.indexOf(";"));
        // test = test.substring(test.indexOf(";") + 1);
        // System.out.println(Integer.parseInt(""));

    }
}
