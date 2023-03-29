package Exercises.CodeWars;
import java.lang.Math;
public class everySquare {
    public static void main(String[] args) {

        System.out.println(squareSum(new int[] {5,2}));
    }


    public static int squareSum(int[] n)
        {
            int i;
            int b = 2;
            int c = 0;
            for (i = 0; i<n.length; i++) {
                c += Math.pow(n[i], b);
            }
            return c;
        }
    }

