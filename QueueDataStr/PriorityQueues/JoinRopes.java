package QueueDataStr.PriorityQueues;

import java.util.PriorityQueue;

public class JoinRopes {
    public static void main(String[] args) {
        // Given ropes of different length.
        // taks is to join ropes such that cost will be minimum
        // cost to connect two ropes is equal to sum of their lengths.

        int ropes[] = {4,3,2,6};
        // Expected o|p = 29
         
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<ropes.length; i++){
            pq.add(ropes[i]);
        }

        int cost =0;

        while(pq.size() > 1 ){
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min+min2);

        }

        System.out.println(cost);
        


    }
    
}
