package Programmers.Practice.BruteForce;

import java.util.Stack;

public class L2_DividePowerGrid {
    private boolean[][] adList;
    private boolean visit[];

    public int solution(int n, int[][] wires) {
        adList = new boolean[n+1][n+1];
        int answer = n;

        for (int i = 0; i < wires.length; i++) {
            int val1 = wires[i][0];
            int val2 = wires[i][1];

            adList[val1][val2] = true;
            adList[val2][val1] = true;
        }

        for (int i = 0; i < wires.length; i++) {
            int val1 = wires[i][0];
            int val2 = wires[i][1];

            adList[val1][val2] = false;
            adList[val2][val1] = false;

            int result = dfs(n, val1);

            adList[val1][val2] = true;
            adList[val2][val1] = true;

            answer = Math.min(answer, result);
        }

        return answer;
    }

    public int dfs(int n, int node) {
        Stack<Integer> stack = new Stack<>();
        visit = new boolean[n+1];
        int count = 1;

        stack.push(node);

        while(!stack.empty()) {
            int pop = stack.pop();
            visit[pop] = true;

            for (int i = 1; i <= n; i++) {
                if (visit[i]) continue;
                if (adList[pop][i]) {
                    stack.push(i);
                    count++;
                }
            }
        }

        return (int)Math.abs(n - 2 * count);
    }
}
