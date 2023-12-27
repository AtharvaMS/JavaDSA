package HashMapDS;

import java.util.HashMap;
import java.util.Set;

public class MajorityElement {

    // find all elements in an array whole count is more than n/3 times.

    public static void main(String[] args) {
        int nums[] = {1,3,2,5,1,3,1,5,1};

        HashMap<Integer, Integer> map = new HashMap<>();

        
        for(int i=0; i<nums.length;i++){
            // if(map.containsKey(nums[i])){
            //     map.put(nums[i], map.get(nums[i]) + 1);
            // }else{
            //     map.put(nums[i], 1);
            // }
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        Set<Integer> set = map.keySet();
        for(Integer s : set){
            if(map.get(s)>nums.length/3){
                System.out.print(s + " ");
            }
        }


    }
    
}
