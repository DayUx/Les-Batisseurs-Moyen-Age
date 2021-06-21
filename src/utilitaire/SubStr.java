package utilitaire;

public class SubStr {
    public static String between(String string, String first, String second) {
        string = string.substring(string.indexOf(first) + 1);
        string = string.substring(0, string.indexOf(second));

        System.out.println(string);
        return string;
    }
}
