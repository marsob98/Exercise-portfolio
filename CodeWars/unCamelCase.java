package Exercises.CodeWars;

public class unCamelCase {
    public static void main(String[] args) {
        System.out.println(converter("SiemasiemaSiemaSiemaSIEMA"));
    }


    private static String converter(String text) {
        if (text == null || text.isEmpty()) {
            return "String is empty";
        }

        String[] words = text.split("(?=[A-Z][a-z])|(?<=[a-z])(?=[A-Z])");
        return String.join(" ", words);
    }

}
