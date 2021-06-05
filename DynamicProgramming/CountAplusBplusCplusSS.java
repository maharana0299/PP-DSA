import java.util.Scanner;

public class CountAplusBplusCplusSS {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
       
        int countEncodings = countEncodingPossible(s);
        
        System.out.println(countEncodings);
    }
    
    static int countEncodingPossible(String st) {
        
        // dp[i] -> encodings possible till i
        st = "." + st;
        
        char s[] = st.toCharArray();
        int dp[] = new int[s.length];
        
        dp[0] = 1;
        dp[1] = s[0] == '0' ? 0 : 1;
        if(dp[1] == 0)
            return 0;
        for(int i = 2; i < dp.length; i++) {
            
            int c = s[i];
            int p = s[i-1];
            
            if(c == '0' && p == '0'){
                dp[i] = 0;
            } else if(p == '0') {
                dp[i] = dp[i-1];
            } else if(c == '0'){
                if(p == '1' || p == '2') {
                    dp[i] = dp[i-2];
                }
            } else {
                dp[i] = dp[i-1];
                
                int num = (c-'0') + 10*(p-'0');
                
                if(num <= 26 && num > 10)
                    dp[i] += dp[i-2];
            }
        }
        
        return dp[s.length-1];
    }
}
