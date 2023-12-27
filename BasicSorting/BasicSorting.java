package BasicSorting;

public class BasicSorting {

    public static void bubbleSort(int numbers[]) {
        // Bubble sort is basically swapping larger number and with adjecent number and
        // putting it at end of array
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }

            }
        }
        printArr(numbers);

    }

    public static void selectionSort(int number[]) {
        // Selection sort finds selects perticular index and finds minimum within array
        // for that index and puts number at that place.
        for (int i = 0; i < number.length; i++) {
            int minEleIndex = i;
            for (int j = i + 1; j < number.length - 1; j++) {
                if (number[minEleIndex] > number[j]) {
                    minEleIndex = j;
                }
                int temp = number[minEleIndex];
                number[minEleIndex] = number[i];
                number[i] = temp;
            }
        }
        printArr(number);

    }

    public static void insertionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int previous = i - 1;
            while (previous > 0 && arr[previous] > current) {
                arr[previous + 1] = arr[previous];
                previous--;
            }
            arr[previous + 1] = current;
        }
        printArr(arr);
    }

    public static void countingSort(int arr[]) {
        // Counts number of occurances of numbers in frequency array and uses it for
        // sorting.
        int largerst = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largerst = Math.max(arr[i], largerst);
        }

        int conut[] = new int[largerst + 1];
        for (int i = 0; i < arr.length; i++) {
            conut[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < conut.length; i++) {
            while (conut[i] > 0) {
                arr[j] = i;
                j++;
                conut[i]--;
            }
        }

        printArr(arr);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int numbers[] = { 1, 4, 1, 3, 2, 4, 3, 7 };
        printArr(numbers);
        System.out.println("Bubble Sort: ");
        bubbleSort(numbers);
        System.out.println("Selection Sort: ");
        selectionSort(numbers);
        System.out.println("Insertion Sort: ");
        insertionSort(numbers);

        System.out.println("Counting sort: ");
        countingSort(numbers);
    }

}
