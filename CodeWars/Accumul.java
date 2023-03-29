package Exercises.CodeWars;

public class Accumul {
    public static void main(String[] args) {
        System.out.println(accum("12345"));
    }

    public static String accum(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = Character.toUpperCase(str.charAt(i));
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    result.append(c);
                } else {
                    result.append(Character.toLowerCase(c));
                }
            }   if (i < str.length() - 1) {
                result.append("-");
            }

        }   return result.toString();
    }
}
