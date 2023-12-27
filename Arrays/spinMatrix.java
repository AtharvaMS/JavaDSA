package Arrays;

public class spinMatrix {
    public static void printSpiral(int matrix[][]) {
        int startRow = 0, startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }

            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // bottom
            for (int i = endCol - 1; i >= startCol; i--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][i] + " ");
            }

            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;

        }
    }

    public static int sumOfDiagonals(int arr[][]) {
        // first method: is using two loops and itrating over each element
        // second single loop method:
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // First diag
            sum += arr[i][i];

            // Secnd Diag
            if (i != arr.length - 1 - i) {
                sum += arr[i][arr.length - 1 - i]; // i+j = n-1 i.e. j = n-i-1
            }
        }

        return sum;

    }

    public static void sorted2dSearch(int arr[][], int key) {
        int startElement = arr.length - 1;
        int col = 0;
        while (col < arr[0].length && startElement >= 0) {
            if (arr[startElement][col] == key) {
                System.out.println("Element Found at posion: (" + startElement + "," + col + ")");
                return;
            } else if (key > arr[startElement][col]) {
                col++;

            } else {
                startElement--;
            }

        }
    }

    public static void main(String[] args) {

        int matrix[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

        // printSpiral(matrix);
        // System.out.println();
        // System.out.println("sum is : " + sumOfDiagonals(matrix));
        sorted2dSearch(matrix, 30);
    }

}
