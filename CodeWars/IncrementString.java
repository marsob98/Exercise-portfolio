package Exercises.CodeWars;

public class IncrementString {
    public static void main(String[] args) {
        System.out.println(incrementString("aaa1"));
    }

    public static String incrementString(String str) {
        StringBuilder result = new StringBuilder();

        if (Character.isDigit(str.charAt(str.length() - 1))) {
            int numDigits = 1;
            while (str.length() - numDigits >= 0 && Character.isDigit(str.charAt(str.length() - numDigits))) {
                numDigits++;
            }
            numDigits--;
            if (numDigits > 0) {
                int num = Integer.parseInt(str.substring(str.length() - numDigits)) + 1;
                result.append(str, 0, str.length() - numDigits);
                result.append(String.format("%0" + numDigits + "d", num));
            } else {
                int num = Integer.parseInt(str.substring(str.length() - 1)) + 1;
                result.append(str, 0, str.length() - 1);
                result.append(num);
            }
        } else {
            result.append(str);
            result.append("1");
        }

        return result.toString();
    }

}
