import Programmers.Practice.BruteForce.L2_DividePowerGrid;
import Programmers.Practice.BruteForce.L2_fatigue;

public class Main {
    public static void main(String[] args) {
        String word = "AA";

        int answer = 0, per = 125;
        for(String s : word.split("")) {
            answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        }

        int i = 1 * (per /= 2);
        System.out.println(i);
    }
}