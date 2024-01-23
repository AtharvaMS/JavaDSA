package DynamicProgramming.DP1;

import java.util.Arrays;

public class CountWaysDp {

    // this is a extension of fiboncii series problem.
    // Total ways to go to the nth stair with only step of 1 and 2.

    //Recursion - O(2^n)
    public static int countWaysRecursion(int n){
        if(n == 0) return 1;
        if(n<0) return 0;

        return countWaysRecursion(n-1) + countWaysRecursion(n-2);
    }

    // memoization -- O(n)
    public static int countWaysMemo(int n, int dp[]){
        if( n == 0) return 1;
        if(n < 0) return 0;

        dp[n] = countWaysMemo(n-1, dp) + countWaysMemo(n-2, dp);
        return dp[n];

    }

    // tubulation -- O(n)
    static public int countWaysTubu(int n, int dp[]){
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(countWaysRecursion(n));
        System.out.println(countWaysMemo(n, dp));
        System.out.println(countWaysTubu(n, dp));
    }
    
}
