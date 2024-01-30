package DynamicProgramming.DP2;

public class UnboundedKnapsack {
    public static int kapsackTubulation(int val[], int wt[], int w){
        int n = val.length;
        int dp[][] = new int[n+1][w+1];

        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }

        for(int i=0; i<dp[0].length; i++){
            dp[0][i] = 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++){
                if(wt[i-1] <= j){
                    //include 
                    int incProfit = val[i-1] + dp[i][j-wt[i-1]];
                    int excProfit = dp[i-1][j];

                    dp[i][j] = Math.max(incProfit, excProfit);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int i=0; i<n+1; i++){
            for(int j=0; j<w+1; j++){
               System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }


        return dp[n][w];
    }

    


    public static void main(String[] args) {
        
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int w =7;

        int dp[][] = new int[val.length+1][w+1];

        for(int i=0; i<dp.length; i++ ){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        // System.out.println(knapsack(val, wt, w, val.length));

        System.out.println(kapsackTubulation(val, wt, w));
        


    }
    
}
