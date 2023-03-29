package Exercises.CodeWars;

public class PigLatin {
    public static void main(String[] args) {
        System.out.println(pigIt("Pig! latin is cool! !"));
    }

    public static String pigIt(String text) {
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.matches("[a-zA-Z]+")) {
                char firstWord = word.charAt(0);
                result.append(word.substring(1));
                result.append(firstWord);
                result.append("ay");
            } else {
                result.append(word);
            }
            result.append(" ");
        }   return result.toString().trim();
    }
}
