package Arrays;

public class trappedRainwater {

    public static int tappedrainwater(int height[]) {
        int n = height.length;
        int maxLeftBoundary[] = new int[n];
        int maxRightBoundary[] = new int[n];
        int waterTrap = 0;

        // calculate max left boundary
        maxLeftBoundary[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeftBoundary[i] = Math.max(maxLeftBoundary[i - 1], height[i]);

        }
        // calculate max right boundary

        maxRightBoundary[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRightBoundary[i] = Math.max(height[i], maxRightBoundary[i + 1]);
        }

        // loop to calculate watertrapped
        for (int i = 0; i < n; i++) {
            waterTrap += Math.min(maxLeftBoundary[i], maxRightBoundary[i]) - height[i]; // only height is taken cause
                                                                                        // width of each column is 1.
        }

        System.out.println("Left Boundary Array: ");
        printArr(maxLeftBoundary);
        System.out.println("Right BOundary Array: ");
        printArr(maxRightBoundary);

        return waterTrap;
    }

    public static void printArr(int inputArray[]) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println("Trapped rainwater is : " + tappedrainwater(height) + " units");
    }

}
