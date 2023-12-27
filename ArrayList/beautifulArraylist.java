package ArrayList;


import java.util.ArrayList;

public class beautifulArraylist {
    public static void main(String[] args) {
        beautifulArraylistwithTarget(5);
        
        

        
    }

    private static void beautifulArraylistwithTarget(int N) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);

        while(arr.size()<N){
            ArrayList<Integer> temp = new ArrayList<>();
            for(Integer e : arr){
                if(2*e <= N) temp.add(2*e);
            }
            for(Integer e : arr){
                if(2*e-1 <= N) temp.add(2*e-1);
            }
            arr = temp;

        }

        System.out.println(arr.toString());
        
    }
}
