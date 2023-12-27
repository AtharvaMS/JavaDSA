package GreedyApproachh;

public class IndianCoinChange {
    public static void main(String[] args) {
        int coins[] = { 2000, 500, 100, 50, 20, 10, 5, 2, 1 };
        int amount = 590;
        int countOfChange =0;

        for(int i = 0 ; i< coins.length; i++){
            if(coins[i] < amount){
                while (amount >= coins[i]) {
                    countOfChange++;
                    System.out.println(coins[i]);
                    amount -= coins[i];
                }
            }
        }

        System.out.println("Total coins required to make change is " + countOfChange);
    }
    
}
