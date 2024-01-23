package DynamicProgramming.DP1;

public class fiboncii {

    // O(2^n) -- Noraml Recursion
    public static int fiboncii(int n){
        if(n ==0 || n ==1 ){
            return n;
        }

        return fiboncii(n-1) + fiboncii(n-2);
    } 
    

    //Memoization -- O(n)--top-down
    public static int memoFib(int n, int dp[]){
        if(n == 0 || n==1){
            return n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        dp[n] = fiboncii(n-1) + fiboncii(n-2);
        return dp[n];

    }

    //Tubulation -- O(n)-- botton-up
    public static int tubulationFib(int n, int dp[]){
        dp[0] =0;
        dp[1] = 1;

        for(int i=2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int dp[] = new int[n+1];
        System.out.println(fiboncii(n));
        System.out.println(memoFib(n, dp));
        System.out.println(tubulationFib(n, dp));
    }
    
}
