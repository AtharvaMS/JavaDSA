package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class pairSum {
    public static void main(String[] args) {
        ArrayList<Integer> height =  new ArrayList<>();
            // 1,8,6,2,5,4,8,3,7
            height.add(1);
            height.add(8);
            height.add(6);
            height.add(2);
            height.add(5);
            height.add(4);
            height.add(8);
            height.add(3);
            height.add(7);

            System.out.println(equalPairSum(height, 9));
    }
    private static boolean equalPairSum(ArrayList<Integer> nums, int target){

        int lp = 0;
        int rp =nums.size() -1;
        Collections.sort(nums);
        while(lp < rp){

            if(nums.get(lp) + nums.get(rp) == target) {
                return true;
            }
            if(nums.get(lp) + nums.get(rp) < target){
                lp++;
            }else{
                rp--;
            }
        }      
        return false;
    }
 }
 
 
