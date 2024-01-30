package DynamicProgramming.DP2;

public class CoinChange {

    // variation of unbounded kanspsack.

    public static int coinChnage(int coins[], int value){
        int n = coins.length;
        int dp[][] = new int[n+1][value+1];

        for(int i=0; i<n+1; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<value+1; i++ ){
            dp[0][i] = 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<value+1; j++){
                if(coins[i-1] <= j){
                    //totalways =  invalid + valid 
                    dp[i][j] = dp[i-1][j] +  dp[i][j-coins[i-1]]; //  ---> this is the main line to understand
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int i=0; i<n+1; i++){
            for(int j=0; j<value+1; j++){
                System.out.print(dp[i][j] +" ");
            }System.out.println("");
        }



        return dp[n][value];
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 3};
        int value = 4;
        // 1 1 1 1
        // 1 2 1
        // 2 2
        // 3 1
        //ans = 4
        System.out.println("Total ways for coin change: " + coinChnage(coins, value));
    }

    
}
