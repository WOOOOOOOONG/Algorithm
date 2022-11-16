package Learning;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class ROR {
    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int answer = 0;
        boolean[][] check = new boolean[maps.length][maps[0].length];
        Queue<Point> q = new LinkedList<>();
        Point p = new Point(maps.length-1, maps[0].length-1);

        q.add(p);

        while (!q.isEmpty()) {
            int size = q.size();
            answer++;

            for (int i = 0; i < size; i++) {
                p = q.poll();

                if (check[p.x][p.y]) continue;

                maps[p.x][p.y] = 0;
                check[p.x][p.y] = true;

                if (p.x == 0 && p.y == 0) return answer;

                if (p.x-1 >= 0 && maps[p.x-1][p.y] == 1) {
                    q.add(new Point(p.x-1, p.y));
                }

                if (p.x+1 < maps.length && maps[p.x+1][p.y] == 1) {
                    q.add(new Point(p.x+1, p.y));
                }

                if (p.y-1 >= 0 && maps[p.x][p.y-1] == 1) {
                    q.add(new Point(p.x, p.y-1));
                }

                if (p.y+1 < maps[0].length && maps[p.x][p.y] == 1) {
                    q.add(new Point(p.x, p.y+1));
                }
            }
        }

        return -1;
    }
}
