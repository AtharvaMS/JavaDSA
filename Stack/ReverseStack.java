package Stack;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        // System.out.println("Previous: ");
        // while(!s.isEmpty()){
        //     System.out.println(s.peek() + " ");
        //     s.pop();
        // }


        reverseStack(s);

        System.out.println("After: ");
        while(!s.isEmpty()){
            System.out.println(s.peek() + " ");
            s.pop();
        }

    }

    private static void reverseStack(Stack<Integer> s) {
        

        if(s.isEmpty()){
            return; 
        }

        int top =s.pop();
        reverseStack(s);
        pusAtBottom.pushAtBottoOfStack(s, top);
        
    }
    
}
