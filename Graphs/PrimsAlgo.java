package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.xml.transform.Source;

public class PrimsAlgo {
    static class Edge{
            int src;
            int dest;
            int weight;
            
            Edge(int src, int dest, int weight){
                this.src =src;
                this.dest = dest;
                this.weight= weight;
            
            }
        }
        
       
        static void createGraph(ArrayList<Edge> graph[]){
            for(int i=0; i<graph.length; i++){
                graph[i] = new ArrayList<>();
            }
            
            graph[0].add(new Edge(0, 1,10));
            graph[0].add(new Edge(0, 3,30));
            graph[0].add(new Edge(0, 2,15));

            graph[2].add(new Edge(2, 0, 15));
            graph[2].add(new Edge(2, 3, 50));

            graph[1].add(new Edge(1, 0, 10));
            graph[1].add(new Edge(1, 3, 40));

            graph[3].add(new Edge(3, 0, 30));
            graph[3].add(new Edge(3, 1, 40));
            graph[3].add(new Edge(3, 2, 50));
        }

        static class Pair implements Comparable<Pair>{
            int v;
            int cost;

            Pair(int v, int cost){
                this.v = v;
                this.cost = cost;

            }

            @Override
            public int compareTo(Pair o) {
                return this.cost - o.cost;
            }
        }

        public static void prims(ArrayList<Edge>[] graph){
            boolean vis[] = new boolean[graph.length];
            PriorityQueue<Pair> pq = new PriorityQueue<>();

            pq.add(new Pair(0, 0));
            int finalcost = 0; // min cost for mst

            while (!pq.isEmpty()) {
                Pair curr = pq.remove();
                if(!vis[curr.v]){
                    vis[curr.v] =true;
                    finalcost +=curr.cost;
                    for(int i=0; i<graph[curr.v].size(); i++){
                        Edge e = graph[curr.v].get(i);

                        pq.add(new Pair(e.dest, e.weight));
                    }
                }
                
            }

            System.out.println("Min cost for MST: "+ finalcost);
        }
    
        public static void main(String[] args) {
    
    
            /*      
             *    
             *      10
             *   1--------0
             *   |      / |
             * 40| 30 /   |15    
             *   |  /     |   
             *   3--------2
             *        50
             */
    
            int v = 6;
            ArrayList<Edge>[] graph = new ArrayList[v];
            createGraph(graph);
            

            prims(graph);
        }
    
}
