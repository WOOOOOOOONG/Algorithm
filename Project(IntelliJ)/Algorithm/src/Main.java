import Programmers.Practice.BruteForce.L2_fatigue;

public class Main {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(new L2_fatigue().solution(k, dungeons));
    }
}