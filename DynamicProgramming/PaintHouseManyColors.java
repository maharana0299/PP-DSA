import java.util.Scanner;

public class PaintHouseManyColors {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int costs[][] = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                costs[i][j] = sc.nextInt();
            }
        }

        int cost = findMinCost(costs, k);
        System.out.println(cost);
    }

    static int findMinCost(int arr[][], int k) {

        int n = arr.length;

        int om = 0;
        int osm = 0;
        int dp[] = new int[k];
        for (int i = 0; i < n; i++) {

            int nm = Integer.MAX_VALUE, nsm = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {

                if (i == 0 || dp[j] != om) {
                    dp[j] = arr[i][j] + om;
                } else {
                    dp[j] = arr[i][j] + osm;
                }

                if (dp[j] < nm) {
                    int t = nm;
                    nm = dp[j];
                    nsm = t;
                } else if (dp[j] < nsm) {
                    nsm = dp[j];
                }
            }

            om = nm;
            osm = nsm;
        }

        return om;
    }
}
