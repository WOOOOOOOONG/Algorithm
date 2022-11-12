package Programmers.Practice.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestGameMap {
    private int[] directX = {0, 0, 1, -1};
    private int[] directY = {1, -1, 0, 0};
    private int[][] visit;

    public int solution(int[][] maps) {
        int answer = 0, m = maps.length, n = maps[0].length;
        visit = new int[m][n];

        bfs(m, n, maps);

        answer = visit[m-1][n-1] == 0 ? -1 : visit[m-1][n-1];
        return answer;
    }

    public void bfs(int m, int n, int[][] maps) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {0, 0});
        visit[0][0] = 1;

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + directX[i];
                int newY = y + directY[i];

                if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                if (visit[newX][newY] == 0 && maps[newX][newY] == 1) {
                    visit[newX][newY] = visit[x][y] + 1;
                    que.add(new int[] {newX, newY});
                }
            }
        }
    }
}
