package QueueDataStr;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingCollectionFrmwrk {
    public static void main(String[] args) {


        // Queue is an interface in Collection Framework. So, we need to instantiate class implementaing Queue interface 
        // There are two classes that implement Queue interface.
        // 1. LinkedList
        // 2. ArrayDeque 
        // we can us both of them to create queue.
        


        //Implemntation using LinkedList
        Queue<Integer> q = new LinkedList();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }


        //Implementaion using ArrayDeque
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(3);
        queue.add(5);
        queue.add(7);
        queue.add(9);

        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }



        
    }
    
}
