package HashMapDS.HashSet;

import java.util.HashMap;

public class LargestArrayWithZeroSum {



    public static void main(String[] args) { //O(n)
        //Brute force approach: USing 2 loops.
        int arr[] = { 15,-2,2,-8,1,7,10,23};

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int length = 0;

        for(int j = 0; j<arr.length;j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                length = Math.max(length, j-map.get(sum));
            }else{
                map.put(sum, j);
            }
        }

        System.out.println("Largest subarray with sum as 0 -> " + length);
    }
}
