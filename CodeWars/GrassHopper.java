package Exercises.CodeWars;


import static javax.sound.midi.MidiSystem.getSequence;

public class GrassHopper {

    public static void main(String[] args) {
        System.out.println(summation(10));
    }

    public static String summation(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return n + " -> " + sum + " -> " + getSequence(n);
    }

    private static String getSequence(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
            if (i != n) {
                sb.append("+");
            }
        }
        return sb.toString();
    }
}

