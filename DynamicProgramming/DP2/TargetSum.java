package DynamicProgramming.DP2;



public class TargetSum {

    
    //TargetSum - Tubulation O(n*target)
    public static boolean targetSum(int num[], int target){
        int n = num.length;
        boolean dp[][] = new boolean[n+1][target+1];

        for(int i=0; i<n+1; i++){
            dp[i][0] = true;
        }

        for(int j =1; j<target+1; j++){
            dp[0][j] = false;
        }

        for(int i=1; i<n+1; i++){
            for( int j=1; j<target+1; j++){
                if(num[i-1] <= j && dp[i-1][j - num[i-1]]){
                    //include
                    dp[i][j] = true;
                    
                }else if (dp[i-1][j] == true) {
                    dp[i][j] = true;
                    
                }

                
            }
        }

        for(int i=0; i<n+1; i++){
            for( int j=0; j<target+1; j++){
                System.out.print(dp[i][j] + " ");
            }   
            System.out.println("");
        }
        

        return dp[n][target];
    }

    public static void main(String[] args) {
        int arr[] = {4,2,7,1,3};
        int targetSum = 5;
        System.out.println(targetSum(arr, targetSum));
    }
    
}
