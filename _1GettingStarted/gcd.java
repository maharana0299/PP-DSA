package  _1GettingStarted;

import java.util.Scanner;

/**
 * gcd
 */
public class gcd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int gcd = 0;
        int dividend = n1;
        int divisor = n2;

        while (dividend % divisor != 0){
            int rem = dividend % divisor;
            dividend = divisor;
            divisor = rem;
        }

        gcd = divisor;

        int lcm = (n1 * n2) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);

        sc.close();
    }
}