package Divide_and_Cunquer;

public class quicksort {
    public static void main(String[] args) {
        
    }

    public static void quickSort(int[] arr, int si, int ei){
        if(si>=ei){
            return;
        }
    
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx, ei);
    }

    private static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si-1;

        for(int j =si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            
        }
            i++;
                int temp = pivot;
                arr[ei] = arr[i];
                arr[i] = temp;

        return i;
    }


    
}
