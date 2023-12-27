package Recursion;

public class Recursion {
    public static void main(String[] args) {
        // printDecr(100);
        // printIncr(100);
        // System.out.print(Fiboncii(10));

        // int array[] = {1,2,3,7,5,6,6,7,5,4,6,4,4};
        // System.out.println(FirstOccurance(array, 4, 2));
        // System.out.println(LastOccurance(array, 4, 0));
        // System.out.println(isSorted(array, 1));

        System.out.println(tilingProblem(3));

        String str = "apnacollegggggggggggdsgfsdsvsfvgbdfgafvafgthyhmjhnfeafvabvghsthaevzcvgeh";
        RemoveDuplicate(str, 0, new StringBuilder(""), new boolean[26]);

        
    }

    public static void printDecr(int n){
        if(n==1){
            System.out.print(1 + " ");
            return;
        }
        System.out.print(n);
        printDecr(n-1);
    }

    public static void printIncr(int n){
        if(n == 1){
            System.out.print(1 + " ");
            return;
        }
        printIncr(n-1);
        System.out.print(n + " ");
        
    }


    public static int Fiboncii(int n){

        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int fib1 = Fiboncii(n-1);
        int fib2 = Fiboncii(n-2);
        
        int fib = fib1 + fib2;
        return (fib);

     }



     public static boolean isSorted(int arr[], int i){

        if(i == arr.length-1){
                return true;
         }

        if(arr[i] > arr[i+1]){
                return false;
         }

         return isSorted(arr, i+1);

            

     }

     //Find first occurance of number in array
     public static int FirstOccurance(int arr[], int key, int i){

        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }


        return FirstOccurance(arr, key, i+1);
     }


     //find last occurance of of number in array
     public static int LastOccurance(int arr[], int key, int i){
        if(i == arr.length-1){
            return -1;
        }

        int isFound = LastOccurance(arr, key, i+1);
        
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
        
     }


     //Given 2xn board and tiles of 2x1 size. Count the number of ways in which tiles can be placed.
     public static int tilingProblem(int n){
        if(n == 0 || n ==1){
            return 1;
        }

        int verticalFit =  tilingProblem(n-1);
        int horizontalFit = tilingProblem(n-2);
        int count = verticalFit + horizontalFit;
        return count;

     }


     public static void RemoveDuplicate(String str, int idx, StringBuilder newString, boolean map[]) {
        
        if(idx == str.length()){
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true){
            RemoveDuplicate(str, idx+1, newString, map);
        } 
        else{
            map[currChar - 'a'] = true;
            RemoveDuplicate(str, idx+1, newString.append(currChar), map);
        }

     }


     
}


