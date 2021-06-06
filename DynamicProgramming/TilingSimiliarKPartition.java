import java.util.Scanner;

public class TilingSimiliarKPartition {

    public static long partitionKSubset_rec(int n, int k) {

        if (n == k)
            return 1;
        if (n == 0 || k == 0)
            return 0;
        return partitionKSubset_rec(n - 1, k - 1) + k * partitionKSubset_rec(n - 1, k);
    }

    public static long partitionKSubset(int n, int k) {

        if (n == 0 || k == 0 || n < k)
            return 0;

        // storing ways to i nums into j partitions
        long[][] dp = new long[n + 1][k + 1];
        // dp[i][j] = dp[i-1][j-1] + k * dp[i-1][j];

        for (int p = 1; p <= n; p++) {
            for (int t = 1; t <= k; t++) {

                if (p < t) {
                    dp[p][t] = 0;
                } else if (t == p) {
                    dp[p][t] = 1;
                } else {
                    dp[p][t] = dp[p - 1][t - 1] + t * dp[p - 1][t];
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        long res = partitionKSubset_rec(n, k);
        System.out.println(res);
    }
}
