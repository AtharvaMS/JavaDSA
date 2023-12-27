package Backtracking;

public class gridWays {

    public static int gridWaysCount(int i, int j, int row, int col){

        //Base Case
        if(i == row-1 && j == col-1){
            return 1;
        }else if(i == row || j == col){
            return 0;
        }


        //recrusion
        int wayRight = gridWaysCount(i, j+1, row, col); // cell's right move choice
        int waydown = gridWaysCount(i+1, j, row, col); // cell's down move choice
        
        return wayRight+waydown;
    }
    public static void main(String[] args) {

        int row = 8; 
        int col = 3;
        System.out.println(gridWaysCount(0, 0, row, col));
        
    }
    
}
