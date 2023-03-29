package Exercises.CodeWars;

public class PhoneNumber {
    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[] {5, 3, 4, 2, 3, 6, 3, 9, 5, 0, 1}));
    }


    public static String createPhoneNumber(int[] numbers) {
        if (numbers.length != 10) {
            System.out.println("The input array should have exactly 10 elements");
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > 9) {
                System.out.println("All elements of the input array should be between 0 and 9");

            }
        }
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);


            // Here's annother correct solution but takes much longer



//        StringBuilder sb = new StringBuilder();
//        StringBuilder sb1 = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//
//        for (int i = 0; i<3; i++) {
//            sb.append(numbers[i]);
//        }
//
//        for (int i = 3; i < 6 ; i++) {
//            sb1.append(numbers[i]);
//        }
//        for (int i = 6; i < 10 ; i++) {
//            sb2.append(numbers[i]);
//        }
//        String result = "(" + sb.toString() + ") ";
//        sb.append(" ");
//        sb1.append("-");
//        String result1 = sb1.toString();
//        String result2 = sb2.toString();
//        String end = result + result1 + result2;
//        return end;
//
//

    }
}