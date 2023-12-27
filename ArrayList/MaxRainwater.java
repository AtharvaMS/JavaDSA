package ArrayList;

import java.util.*;

public class MaxRainwater {
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


        System.out.println(trappedMaxWater(height));
        
    }

    private static int trappedMaxWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() -1;

        while(lp < rp) {
            // calculate area
            int area = (rp-lp) * (Math.min(height.get(rp), height.get(lp)));
            maxWater = Math.max(maxWater, area);

            //move pointer
            if(height.get(lp) < height.get(rp)) {
                lp++;
            }else{
                rp--;
            }
        }

        return maxWater;

    }

    
}
