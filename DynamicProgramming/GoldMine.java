import java.util.Scanner;

public class GoldMine {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int golds[][]= new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                golds[i][j] = sc.nextInt();
            }
        }

        // Integer qb[][] = new Integer[n][m];

        // int max = 0;
        // // from starting we can have n option to start from
        // for(int i = 0; i < n; i++) {
        //     int gsf = collectGoldsFromMine(golds,i,0,qb);
        //     if(gsf > max) {
        //         max = gsf;
        //     }
        // }

        int max = collectGoldsFromMine(golds);
        System.out.println(max);
    }

    private static int collectGoldsFromMine(int[][] golds) {
        
        int n = golds.length;
        int m = golds[0].length;

        // from i,j spot , how much gold we can collect till n-1 th row
        int dp[][] = new int[n][m];
        int max = Integer.MIN_VALUE;
        // direction of traversal should be coulum wise
        for(int j = m-1; j >= 0; j--) {

            int cmax = Integer.MIN_VALUE;
            for(int i = n-1; i >= 0; i--) {

                if(j == m-1){
                    dp[i][j] = golds[i][j];
                } else if(i+1 < golds.length && i-1 >= 0) {
                    dp[i][j] = golds[i][j] + Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1]));
                }else if(i+1 < golds.length){
                    dp[i][j] = golds[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
                } else if(i-1 >= 0) {
                    dp[i][j] = golds[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
                }

                if(dp[i][j] > cmax)
                    cmax = dp[i][j];
            }

            if(cmax > max)
                max = cmax;
        } 
        return max;
    }

    // at pos i, we can have 3 option to move and then we return max of it 
    private static int collectGoldsFromMine(int[][] golds, int i, int j, Integer[][] qb) {
        
        // we have three options
        if(i < 0 || i >= golds.length)
            return 0;
        if(j == golds[0].length){
            return golds[i][j];
        }

        if(qb[i][j] != null)
            return qb[i][j];
        int c1 = collectGoldsFromMine(golds, i+1, j+1, qb);
        int c2 = collectGoldsFromMine(golds, i, j+1, qb);
        int c3 = collectGoldsFromMine(golds, i-1, j-1, qb);
        return qb[i][j] = Math.max(c1, Math.max(c2, c3));
    }
}
