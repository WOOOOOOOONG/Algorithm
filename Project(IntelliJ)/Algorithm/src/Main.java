import Programmers.Practice.BruteForce.L2_DividePowerGrid;
import Programmers.Practice.BruteForce.L2_fatigue;

public class Main {
    public static void main(String[] args) {
        int answer = 0, per = 3905;
        String word = "A";
        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;

        System.out.println(per);
    }
}