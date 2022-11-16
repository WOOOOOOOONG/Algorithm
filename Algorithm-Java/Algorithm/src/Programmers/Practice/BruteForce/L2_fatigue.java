package Programmers.Practice.BruteForce;

public class L2_fatigue {
    private int answer = 0;
    private boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];

        raid(0, k, dungeons);

        return answer;
    }

    public void raid(int clear, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && k >= dungeons[i][0]) {
                visit[i] = true;
                raid(clear+1, k-dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
        answer = Math.max(answer, clear);
    }
}
