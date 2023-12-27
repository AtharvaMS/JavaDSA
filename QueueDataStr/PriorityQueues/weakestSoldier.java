package QueueDataStr.PriorityQueues;

import java.util.PriorityQueue;


public class weakestSoldier {

    static class soldier implements Comparable<soldier>{
        int soldiers;
        int idx;

        soldier(int soldier, int idx){
            this.soldiers = soldier;
            this.idx = idx;
        }

        @Override
        public int compareTo(soldier o) {
           if(this.soldiers == o.soldiers){
                return this.idx - o.idx;
           }else{
                return this.soldiers - o.soldiers;
           }
        }

    }

    public static void main(String[] args) {
        //Find k nearest weak rows.
        //rows i are weak if
        //   1. number of soldiers in row i are less then number of soldiers in row j 
        //   2. If soldiers in rows are same then i<j

        int soldiers[][] = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};

        PriorityQueue<soldier> s = new PriorityQueue<>();
        for(int i=0; i<soldiers.length;i++){
            int count =  0;
            for(int j = 0; j<soldiers[i].length;j++){
                count += soldiers[i][j] == 1 ? 1:0;
            }
            s.add(new soldier(count, i));
        }

        System.out.println("C" + s.remove().idx);
        System.out.println("C" + s.remove().idx);

    }   
    
}
