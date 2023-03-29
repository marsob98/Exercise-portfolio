package Exercises.CodeWars;


public class RomanNumeralsEncoder {

    public static void main(String[] args) {
        System.out.println(solution(3875));
    }
    private static final int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String solution(int n) {

    StringBuilder result = new StringBuilder();
    int i = 0;

    while (n > 0) {
        if (n >= arabicValues[i]) {
            result.append(romanNumerals[i]);
            n -= arabicValues[i];
        } else {
            i++;
        }
    }

    return result.toString();
    }


}
