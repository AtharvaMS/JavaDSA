package ArrayList;

import java.util.ArrayList;

public class monotoneIncOrDec {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(3);

        System.out.println(isMonotonous(list));
        
        
    }

    private static boolean isMonotonous(ArrayList<Integer> list) {
        int n = list.size()-1;
        int i =0;
        boolean inc = true;
        boolean dec =true;
        while(i<n){
            
            if(list.get(i)>list.get(i+1)){
                inc = false;
            }

            if(list.get(i)<list.get(i+1)){
                dec = false;
            }
            i++;
        }

        return inc || dec;
    }
    
}
