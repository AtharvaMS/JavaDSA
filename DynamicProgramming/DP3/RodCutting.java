package DynamicProgramming.DP3;

public class RodCutting {

    // tubulation - O(n*length of rod) - O(n*m)
    public static int rodCutting(int length[], int prices[], int rodlength){

        int n = prices.length;
        int dp[][] = new int[n+1][rodlength+1];

        //initialize dp[][] with 0. Default intialize by java.

        for(int i=1; i<n+1; i++){
            for( int j=1; j<rodlength+1; j++){
                //valid
                if(length[i-1] <= j){
                    //max between include and exclude option
                    dp[i][j] = Math.max(prices[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int i=0; i<n+1; i++){
            for( int j=0; j<rodlength+1; j++){
                System.out.print(dp[i][j] +" ");
            }
            System.out.println("");
        }

        return dp[n][rodlength];
        
    }

    public static void main(String[] args) {
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int rodLength = 8;
        //Ans = 22 = len(6+2)
        
        System.out.println("Maximum price will be: "+ rodCutting(length, price, rodLength));
    }
    
}
