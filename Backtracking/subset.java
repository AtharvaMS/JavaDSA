package Backtracking;

public class subset {
    //Find all subset of string using recursion.
    public static void main(String[] args) {
        String s = "abcde";
        subsetOfString(s, 0, "");

    }
    
    public static void subsetOfString(String str, int i , String ans){
        //base case
        if(i==str.length()){
            if(ans.length() == 0){
                System.out.println("Null");
            }else{
                System.out.println(ans);
            }
            
            return;
        }


        //recursion + backtracking
        subsetOfString(str, i+1, ans+str.charAt(i)); // for yes choice of perticular charactor

        subsetOfString(str, i+1, ans); //For No choice of perticular charactor.
    }
}
