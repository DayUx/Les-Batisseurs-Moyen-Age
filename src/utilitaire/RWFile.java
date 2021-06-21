package utilitaire;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that allow you to read and write files
 */
public class RWFile {

    /**
     * Allow you to read a file
     * 
     * @param fileName the path of the file you want to read
     * @return return the content of the file
     */
    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> liste = new ArrayList<String>();
        try {
            // ouverture du fichier
            Scanner in = new Scanner(new FileReader(fileName));
            // lecture et ajout des lignes une par une
            while (in.hasNextLine()) {
                liste.add(in.nextLine());
            }
            // fermeture du fichier ouvert en lecture
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("readFile - Fichier non trouve : " + fileName);
        }
        return liste;
    }

    /**
     * Allow you to write a file
     * 
     * @param liste    The content of the file you want to write
     * @param fileName The path of the file you want to write
     */
    public static void writeFile(ArrayList<String> liste, String fileName) {
        try {
            // ouverture du fichier
            PrintWriter out = new PrintWriter(fileName);
            // ecriture dans le fichier
            for (String ligne : liste)
                out.println(ligne);
            // fermeture du fichier
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        }
    }

}
