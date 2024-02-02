package DynamicProgramming.DP3;

public class LongestCommonSubsequence {


    // Recursion -> O(2^(n+m)) -> int worst case->counts all possible subsequences of both the strings
    public static int lcsRecursion(String s1, String s2, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return lcsRecursion(s1, s2, n-1, m-1) + 1;
        }else{
            //n-1, m
            int firstStringRecuction = lcsRecursion(s1, s2, n-1, m);
            int secondStringReducton = lcsRecursion(s1, s2, n, m-1);
            return Math.max(firstStringRecuction, secondStringReducton);
        }

        

    }


    //Memoization -> O(n*m)
    public static int lcsMemoization(String s1, String s2, int n, int m, int dp[][]){
        if(n == 0 || m == 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[n][m] = lcsRecursion(s1, s2, n-1, m-1) + 1;
        }else{
            //n-1, m
            int firstStringRecuction = lcsRecursion(s1, s2, n-1, m);
            int secondStringReducton = lcsRecursion(s1, s2, n, m-1);
            return dp[n][m] = Math.max(firstStringRecuction, secondStringReducton);
        }

        

    }



    public static void main(String[] args) {
        String st1 = "abcdef";
        String str2 = "acdgf";
        int n = st1.length();
        int m = str2.length();
        
        System.out.println("LCS Recusrion ans: "+lcsRecursion(st1, str2, st1.length(), str2.length()));

        //initialization
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                dp[i][j] = -1;
            }
        }
        
        System.out.println("LCS Memoizaiton ans: "+ lcsMemoization(st1, str2, n, m, dp));
    }
    
}
