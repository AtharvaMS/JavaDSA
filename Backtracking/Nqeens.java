package Backtracking;

public class Nqeens {

    public static void nQueens(char[][] board, int row){
        //base case
        if(row == board.length){
            printBoard(board);
            return;
        }

        //column loop
        for(int i=0; i<board.length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                nQueens(board, row+1);
                board[row][i] = 'X';
            }
            
        }


    }




    private static boolean isSafe(char[][] board, int row, int col) {
        //vertical
        for(int i = row-1; i>=0; i--){
             
            if(board[i][col] == 'Q'){
                return false;
            }  
        }

        // diagonal up left
        for(int i = row -1, j = col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //diagonal up right
        for( int i = row - 1, j = col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }




    private static void printBoard(char[][] board) {
        System.out.println("------Board------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] +" ");
                 
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        int n = 8;
        char[][] board = new char[n][n];

        for(int i=0;i<board.length;i++){
            for(int j = 0; j<board.length;j++){
                board[i][j] = 'X';
            }

        }

        nQueens(board, 0);
        



    }

}
