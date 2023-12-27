package Arrays;




public class BinarySearch {

    public static void printSubarrays(int numbers[]){
        for(int i =0;i<numbers.length;i++){
            for(int j = i;j<numbers.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(numbers[k]+ " ");
                }System.out.println("");
            }System.out.println("---------");
        }
    }

    private static void maxSubarraySumPrefixarray(int numbers[]){
        int prefixArray[] = new int[numbers.length];
        int currSum=0; int maxSum =0;
        prefixArray[0]=numbers[0];

        // calculating prefix subarray
        for(int i=1; i<numbers.length;i++){
            prefixArray[i] = prefixArray[i-1] + numbers[i];
        }

        for(int i =0;i<numbers.length;i++){
            for(int j = i;j<numbers.length;j++){
                
                currSum = i==0 ? prefixArray[j] : prefixArray[j] - prefixArray[i-1];
                if(maxSum < currSum){
                    maxSum=currSum;
                }
            
            }
            
        }

        System.out.println("Max sum is: " + maxSum);
    }

    public static void kadanesAlgo(int numbers[]){
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i =0; i<numbers.length;i++){
            currentSum = currentSum + numbers[i];
            if(currentSum<0){
                currentSum=0;
            }
            maxSum = Math.max(currentSum,maxSum);

        }

        System.out.println("Max Sum using kadanes Algorithm is: "+ maxSum);
    }
    

    public static void numPairs(int numbers[]){
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length;j++){
                System.out.print("("+numbers[i]+","+numbers[j]+")");
            }
            System.out.println("");
        }
    }
    
    
    public static int binarySearch(int numbers[], int key){
        int start = 0;
        int end = numbers.length-1;
        
        while(start<=end){
            int mid = (start + end)/2;
            if(numbers[mid] == key){
                return mid;
            
            }
            else if(numbers[mid] < key){
                start = mid+1;

            }else{
                end = mid-1;
            }
        }

        return -1;

    }
    public static void main(String[] args) {
        int numbers[] = {1,-2,6,-1,3};
        int key = 67;
        System.out.println("Index for key is: " +binarySearch(numbers, key));
        // numPairs(numbers);
        // printSubarrays(numbers);
        maxSubarraySumPrefixarray(numbers);
        kadanesAlgo(numbers);
        

    
    }
    
}
