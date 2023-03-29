package Exercises.CodeWars;

import java.util.Arrays;

public class ArrayLeftRight {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 3, 2, 1};
        int[] arr2 = {1, 100, 50, -51, 1, 1};
        int[] arr3 = {20, 10, -80, 10, 10, 15, 35};

        System.out.println(findEvenIndex(arr1)); // output: 3
        System.out.println(findEvenIndex(arr2)); // output: 1
        System.out.println(findEvenIndex(arr3)); // output: 0
    }

    public static int findEvenIndex(int[] arr) {
        int sumLeft = 0;
        int sumRight = Arrays.stream(arr).sum();

        for (int i = 0; i < arr.length; i++) {
            sumRight -= arr[i];

            if (sumLeft == sumRight) {
                return i;
            }

            sumLeft += arr[i];
        }

        return -1;
    }
}