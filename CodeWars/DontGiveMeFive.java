package Exercises.CodeWars;

public class DontGiveMeFive {
    public static void main(String[] args) {
        System.out.println(dontGiveMeFive(1, 73));
    }
    public static int dontGiveMeFive(int start, int end){
        int ans = 0;
        for (int i = start; i <= end; i++) {
            if (!("" + i).contains("5")) ans++;
            System.out.println(ans);
        }
        return ans;
    }
}





