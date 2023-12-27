package QueueDataStr.PriorityQueues;

import java.util.Comparator;
import java.util.PriorityQueue;




public class PriorityQ {

    // Priority Queues are implemented using Collection Framework.
    // PQs internally uses HEAP data structure to manipulate data.

    //For more info -> HEAP folder
    
    // insert() -> O(log n)
    // delete() -> O(log n)
    // peek() - O(1)

    static class student implements Comparable<student>{
        String name;
        int marks;

        student(String name, int marks){
            this.name = name;
            this.marks = marks;
        }

        @Override
        public int compareTo(student o) {
            return this.marks - o.marks;  
        }
    }



    public static void main(String[] args) {


        //PriorityQueue using java collection framework
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(4);
        pq.add(10);
        pq.add(7);
        pq.add(9);

        PriorityQueue<student> s = new PriorityQueue<>(Comparator.reverseOrder());
        s.add(new student("abc", 6));
        s.add(new student("pqr", 10));
        s.add(new student("xyz", 7));
        s.add(new student("jkl", 8));





        while(!s.isEmpty()){
            System.out.println(s.peek().marks + "->" + s.peek().name);
            s.remove();
        }
        
    }


    


}
