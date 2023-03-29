package Exercises.CodeWars;

import java.util.Arrays;

public class CountBy {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBy(2, 5)));
    }

//    i = x; i <= x*n; i+=x
    public static int[] countBy(int x, int n){
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = x * (i +1);
        }

        return list;
    }

}
