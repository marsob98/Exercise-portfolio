package Exercises.CodeWars;

public class LiczbaArmstronga {
    public static void main(String[] args) {
        System.out.println(isNarcissistic(153));
    }

    public static boolean isNarcissistic(int number) {
        int sum = 0;
        int originalNumber = number;
        int numberOfDigits = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numberOfDigits);
            number /= 10;
            System.out.println(number);
            System.out.println(digit);

        }

        return sum == originalNumber;
    }

}
