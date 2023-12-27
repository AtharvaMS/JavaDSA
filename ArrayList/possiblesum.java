package ArrayList;

import java.util.ArrayList;

public class possiblesum {
    // Brute force method -O(n*n)
    public static boolean possibleSum(ArrayList<Integer> list, int target){
        for(int i = 0 ; i< list.size(); i++){
            for(int j = i+1 ;j<list.size();j++){
                if(list.get(i) + list.get(j) == target){
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(7);
        list.add(8);
        list.add(8);
        list.add(76);
        list.add(45);

        System.out.println(possibleSum(list, 33));

    }
    
}
