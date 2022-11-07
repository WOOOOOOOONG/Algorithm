package Company_Test.Others;

public class Test3 {
    public long solution(int k) {
        int[] dp = new int[50];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 5;
        dp[6] = 7;
        dp[7] = 9;
        //dp[11] = 99;

        if(k == 1) {
            return 0;
        }

        dfs(k, dp);

        return k;
    }

    public int dfs(int k, int[] dp) {
        if (dp[k] != 0) return dp[k];
        if (k == 0) return k;

        return dp[k] = dfs(k - 2, dp) + dfs(k - 3, dp) + dfs(k - 4, dp)
                + dfs(k - 5, dp) + dfs(k - 6, dp) + dfs(k - 7, dp);
    }
}
