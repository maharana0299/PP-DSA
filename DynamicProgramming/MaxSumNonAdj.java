public class MaxSumNonAdj {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            
        }
        // int max = nonAdjSum(arr);
        int[] rec = adjRec(arr,0);
        
        System.out.println(Math.max(rec[0],rec[1]));
    }
    
    static int nonAdjSum(int[] arr) {
        
        int n = arr.length;
        int inc = 0;
        int xcl = 0;
        
        for(int i = 0; i < n; i++) {
            
            // if included 
            int t = inc;
            inc = xcl + arr[i];
            // if choose to exclude
            xcl = Math.max(t,xcl); // old include and excl  max
        }
        
        return Math.max(inc,xcl);
    }
    
    // recursion greedy
    // 0-> inc
    // 1-> exl
    static int[] adjRec(int[] arr, int i) {
        
        if(i == arr.length-1) {
            int a[] = new int[2];
            
            a[0] = arr[i];
            a[1] = 0;
            return a;
        }
        
        int[] a = adjRec(arr,i+1);  
        
        int oi = a[0];
        int ox = a[1];
        a[0] = ox + arr[i];
        a[1] = Math.max(oi,ox);
        return a;
    }
}
