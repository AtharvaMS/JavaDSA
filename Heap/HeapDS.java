package Heap;

public class HeapDS {

    public static void HeapSortMethod(int arr[]){
        // step1: create max heap from arr 
        int n = arr.length;
        for(int i = n/2; i>=0;i--){
            Heapify(arr, i , n);
        }

        //  step 2: swop first and last element
        for(int i=n-1; i>0; i--){
            //swop
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //Heap adjustment from 0th index
            Heapify(arr, 0, i);

        }
        

        

    }


    private static void Heapify(int[] arr, int idx, int n) {
        int root = idx;
        int left = 2*idx+1;
        int right = 2*idx+2;

        if(left < n && arr[left] > arr[root]){
            root = left;
        }

        if(right < n && arr[right] > arr[root]){
            root = right;
        }

        if(root != idx){
            int temp = arr[root];
            arr[root] = arr[idx];
            arr[idx] = temp;

            Heapify(arr, root, n);
        }
    } 


    public static void main(String[] args) {
        int arr[] = {1,2,4,5,3};

        HeapSortMethod(arr);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        
    }

    
}
