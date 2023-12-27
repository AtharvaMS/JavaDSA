package Stack;
import java.util.*;

public class reverseString {

    static Stack<Character> c = new Stack<>();
    public static void main(String[] args) {
        

        String s = "Atharva Sawleshwarkar";
        reverseStringUsingRecursion(s);
        StringBuilder b = new StringBuilder();
        while(!c.isEmpty()){
            b.append(c.pop());
        }

        System.out.println(b.toString());
    }

    private static void reverseStringUsingRecursion(String s) {
        if(s.length() == 0){
            return;
        }
        
        c.push(s.charAt(0));
        reverseStringUsingRecursion(s.substring(1));

    }
    
}
