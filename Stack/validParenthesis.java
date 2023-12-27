package Stack;

import java.util.*;

public class validParenthesis {
    public static void main(String[] args) {
        // String s = "{{{(())}{{[[[[[[]]]]]]}}}[[[]]]}";
        String str1 = "((a+b))"; //duplicate parenthesis.(Not necessary parenthesis)
        // String str2 = "((a+b)+(c+d))";

        // System.out.println(isVaildParenthesis(s)); 
        System.out.println(isDuplicate(str1)); 
        
    }

    
    private static boolean isDuplicate(String s) { // Time Complixity: O(n)
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == ')'){
                int count = 0;
                while(stack.pop() != '('){
                    count++;
                }
                if(count < 1){
                    return true;
                }
            }
            else{
                stack.push(ch);
            }

        }

        return false;
    }

    private static boolean isVaildParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch == '[' || ch == '('){ //Opening Braces
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                if((stack.peek() == '(' && ch == ')') || (stack.peek() == '[' && ch == ']') || (stack.peek() == '{' && ch == '}')){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }

        return stack.isEmpty();

        
        
        
        
    }
    
}
