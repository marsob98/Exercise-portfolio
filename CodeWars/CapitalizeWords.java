package Exercises.CodeWars;

public class CapitalizeWords {
    public static void main(String[] args) {
        System.out.println(toJadenCase("how can mirrors be real if our eyes aren't real"));
    }

    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }

        String[] words = phrase.split(" ");
        String firstWord = capitalize(words[0]);


        StringBuilder result = new StringBuilder(firstWord);
        for (int i = 1; i < words.length; i++) {

            result.append(" ");
            result.append(capitalize(words[i]));
        }
        return result.toString();
    }

    private static String capitalize(String word) {
        return Character.toUpperCase(word.charAt(0))
                + word.substring(1);
    }
}

