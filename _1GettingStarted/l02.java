package  _1GettingStarted;

/**
 * l02
 */
public class l02 {

    public static int countDigits(int n) {
        if (n <= 0)
         return 0;
        return 1 + countDigits(n/10);
    }

    public static void printDigits(int n) {

        int dig = countDigits(n);
        int pow = (int) Math.pow(10, dig-1);
        while (pow > 0) {
            int ld = n/pow;
            n = n%pow;

            System.out.println(ld);
            pow /= 10;
        }
    }
    
    public static int reverseNumber(int n) {

        int rev = 0;
        int dig = countDigits(n);

        while(dig > 0) {
            rev = rev*10 + n%10;
            n /= 10;
        }

        return rev;
    }

    public static int rotateNumber(int n, int k) {

        int numberOfDigits = countDigits( n);
        k = k % numberOfDigits;  // taking mod to get minumum number of k

        if (k < 0)
            k = k + numberOfDigits;; // converting negative rotation to psoitive rotation 
        
        int div = 1;
        int mlt = 1;

        for (int i =1; i<= numberOfDigits; i++ ){
            if (i <= k)
                div *= 10;
            else  
                mlt *= 10;
            
        }

        int q = n / div;
        int r = n % div;

        int rotated = r*mlt + q;
        
        return rotated;
    }
}