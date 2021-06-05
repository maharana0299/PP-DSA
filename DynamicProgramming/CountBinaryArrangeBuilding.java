import java.util.*;

public class CountBinaryArrangeBuilding {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // b represents buildings, s represents space
        long b = 1, s = 1;

        for (int i = 2; i <= n; i++) {
            long nb = s;
            long ns = b + s;

            b = nb;
            s = ns;
        }

        long total = b + s;

        // every way can come with every other way so total ways = total * total
        System.out.println(total * total);
    }
}
