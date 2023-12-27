package HashMapDS.HashSet;

import java.util.HashSet;

public class CountDistinctELement {
    public static void main(String[] args) {
        int nums[] = {4,3,2,5,6,7,3,2,1,};


        HashSet<Integer> set = new HashSet<>();
        for(Integer i : nums){
            set.add(i);
        }

        System.out.println(set.size());
    }
    
}
