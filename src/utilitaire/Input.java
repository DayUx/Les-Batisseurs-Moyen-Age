package utilitaire;

import java.util.Scanner;

public class Input {
    public static String getString() {
        String res = "";
        Scanner scanner = new Scanner(System.in);
        res = scanner.nextLine();
        return res;
    }

    public static int getInt() {
        int res;
        Scanner scanner = new Scanner(System.in);
        res = Integer.parseInt(scanner.nextLine());
        return res;
    }
}
