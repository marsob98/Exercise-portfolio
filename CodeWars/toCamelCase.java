package Exercises.CodeWars;

public class toCamelCase {
    public static void main(String[] args) {
        String text = "the-stealth-warrior";
        String text1 = "The_Stealth_Warrior";
        String text2 = "The_Stealth-Warrior";
        String text3 = null;
        System.out.println(converter(text));
        System.out.println(converter(text1));
        System.out.println(converter(text2));
        System.out.println(converter(text3));

    }


    private static String converter(String text) {
        if (text == null || text.isEmpty()) {
            return "String is empty";
        }

        String[] words = text.split("[-_]");
        String firstWord = words[0];


        StringBuilder result = new StringBuilder(firstWord);
        for (int i = 1; i < words.length; i++) {
            result.append(capitalize(words[i]));
        }
        return result.toString();
    }

    private static String capitalize(String word) {
        return Character.toUpperCase(word.charAt(0))
                + word.substring(1);
    }

}
