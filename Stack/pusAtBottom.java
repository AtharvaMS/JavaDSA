package Stack;

import java.util.Stack;

public class pusAtBottom {
    //push at the bottom of stack!

    //Answer: Can be solved using arrays, list and other stuffs but takes extra space!
    //Optimal answer: Solve using recursion.

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        pushAtBottoOfStack(s, 9);
        // System.out.println(s);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
    

    public static void pushAtBottoOfStack(Stack<Integer> s, int i) {
        if(s.isEmpty()){
            s.push(i);
            return;
        }

        int top =s.pop();
        pushAtBottoOfStack(s, i);
        s.push(top);
    }
}
