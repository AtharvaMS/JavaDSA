package ArrayList;

import java.util.ArrayList;


public class pairSumRotated {
    public static void main(String[] args) {
        ArrayList<Integer> height =  new ArrayList<>();
            // 1,8,6,2,5,4,8,3,7
            height.add(11);
            height.add(12);
            height.add(13);
            height.add(14);
            height.add(6);
            height.add(7);
            height.add(8);
            height.add(9);
            height.add(10);

            System.out.println(equalPairSum(height, 27));
    }
    private static boolean equalPairSum(ArrayList<Integer> nums, int target){
        int lp =0;
        int rp =0;

        for(int i = 0; i<nums.size(); i++){
            if(nums.get(i) > nums.get(i+1)){
                rp = i;
                lp = i+1;
                break;
            }
        }
        
        
        while(lp != rp){

            if(nums.get(lp) + nums.get(rp) == target) {
                return true;
            }
            if(nums.get(lp) + nums.get(rp) < target){
                lp = (lp+1)%nums.size();
            }else{
                rp = (rp - 1 + nums.size()) % nums.size();
            }
        }      
        return false;
    }
}
