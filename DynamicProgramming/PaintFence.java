public class PaintFence {

    /**
     * 
     * @param n number of fences 
     * @param k number of colors 
     * @return ways to paint such that no two cosecutive fence have same color 
     */
    public int paintFence(int n, int k) {
        if(n == 1)
            return k;
        long mod = (long)(1e9) + 7;
        /**
         * ss -> valid paints of i fence such that last two are painted with same color
         * sd -> valid paints of i fence such that last two are painted with different color
         */

        /**
         * for 2 fences. ss => k(as there are k colors and two places )
         *               sd => k in first pos and k-1 in second pos 
         */
        long ss = k; // paint with last two same
        long sd = k*(k-1); // paint with last two diff
        long t = ss + sd;
        
        for(int i = 2; i < n; i++) {
            /**
             * for ss put same color in sd state so we have sd ways
             * for sd, put a different color in total ways , total * k-1
             */
            long nss = sd % mod;
            long nsd = t*(k-1) % mod;
            
            ss = nss;
            sd = nsd;
            t = ss + sd;
            t = t % mod;
        }
        
        return t;
    }
}
