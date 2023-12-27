package Heap;

import java.util.PriorityQueue;

import Stack.reverseString;

public class NearbyCars {

    static class Point implements Comparable<Point>{
        int x; int y; int distSq; int idx;

        Point(int x, int y, int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p){
            return this.distSq - p.distSq;
        }
    }



    public static void main(String[] args) {
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k =2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i=0; i<pts.length;i++){
            int dist = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], dist, i));
        }

        for(int i =0; i<k; i++){
            System.out.println("C" + pq.peek().idx);
            pq.remove();
        }

        
    }
    
}
