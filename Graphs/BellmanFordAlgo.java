package Graphs;

import java.util.ArrayList;

public class BellmanFordAlgo {
    static class Edge{
            int src;
            int dest;
            int weight;
            
            Edge(int src, int dest, int weight){
                this.src =src;
                this.dest = dest;
                this.weight =weight;
            
            }
        }
        
       
        static void createGraph(ArrayList<Edge> graph[]){
            for(int i=0; i<graph.length; i++){
                graph[i] = new ArrayList<>();
            }
    
            graph[0].add(new Edge(0, 1, 2));
            graph[0].add(new Edge(0, 2, 4));

            graph[1].add(new Edge(1, 2, -4));
            graph[2].add(new Edge(2, 3, 2));

            graph[3].add(new Edge(3, 4, 4));
            graph[4].add(new Edge(4, 1, -1));
            
            
        }

        // static class Pair implements Comparable<Pair>{
        //     int n; 
        //     int path;

        //     Pair(int n, int path){
        //         this.n = n;
        //         this.path = path;
        //     }

        //     @Override
        //     public int compareTo(Pair o) {
        //         return this.path - o.path;
        //     }
        // }

        public static void bellmanFord(ArrayList<Edge>[] graph, int src){
            int dist[] = new int[graph.length];

            for(int i=0; i<dist.length; i++){
                if(i != src){
                    dist[i] = Integer.MAX_VALUE;
                }
            }

            int V = graph.length;
            // Final Time complexity = O(V*E) 
            // loop v-1 times O(V)
            for(int i=0; i<V-1; i++){
                //edges O(E)
                for(int j=0; j<graph.length; j++){
                    for(int k=0; k<graph[j].size(); k++ ){
                        Edge e = graph[j].get(k);

                        int u = e.src;
                        int v =e.dest;
                        int wt =e.weight;

                        //Relaxation
                        if(dist[u] != Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                            dist[v] = dist[u]+ wt;
                        }
                    }
                }


            }

            // print
            for(int i=0; i<dist.length; i++){
                System.out.println(dist[i] +" ");

            }
           
            System.out.println("");
        }





        // public static void dijkstra(ArrayList<Edge> graph[], int src){ //O(V + ElogV)
        //     int dist[] = new int[graph.length];
        //     for(int i=0; i<graph.length; i++){
        //         if(i != src){
        //             dist[i] = Integer.MAX_VALUE; // initialize all distances
        //         }
        //     }

        //     PriorityQueue<Pair> q =new PriorityQueue<>();
        //     boolean vis[] = new boolean[graph.length];
        //     q.add(new Pair(src, 0));

        //     while (!q.isEmpty()) {
        //         Pair curr = q.remove();
        //         if(!vis[curr.n]){
        //             vis[curr.n] = true;
        //             //neighbours
        //             for(int i=0; i<graph[curr.n].size(); i++){
        //                 Edge e = graph[curr.n].get(i);
        //                 int u = e.src;
        //                 int v =e.dest;
        //                 int wt =e.weight;

        //                 if (dist[u] + wt < dist[v]) {
        //                     dist[v] = dist[u] + wt;
        //                     q.add(new Pair(v, dist[v]));
                            
        //                 }
        //             }
        //         }
                
        //     }

        //     //print all
        //     for(int i=0; i<dist.length; i++){
        //         System.out.print(dist[i]+ " ");
        //     }
        //     System.out.println();

        // }
    
        public static void main(String[] args) {
    
    
            /*              -1
             *       1  ---------- 4
             *     2/  |           |  
             *   0     | -4       4|
             *    4 \  |           |
             *         2  -------  3
             *              2
             */
    
            int v = 5;
            ArrayList<Edge>[] graph = new ArrayList[v];
            createGraph(graph);
            bellmanFord(graph, 0);
           
            

            
           
             
        }

    
}
