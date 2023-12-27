package Graphs;

import java.util.ArrayList;



public class AllPathsBetnNodes {

    static class Edge{
            int src;
            int dest;
            
            Edge(int src, int dest){
                this.src =src;
                this.dest = dest;
            
            }
        }
        
       
        static void createGraph(ArrayList<Edge> graph[]){
            for(int i=0; i<graph.length; i++){
                graph[i] = new ArrayList<>();
            }
    
            // graph[0].add(new Edge(0, 1));
            graph[0].add(new Edge(0, 3));
    
            // graph[1].add(new Edge(1, 0));
            // graph[1].add(new Edge(1, 3));
    
            graph[2].add(new Edge(2, 3));
            // graph[2].add(new Edge(2, 4));
            
            graph[3].add(new Edge(3, 1));
            // graph[3].add(new Edge(3, 4));
            
            graph[4].add(new Edge(4, 0));
            graph[4].add(new Edge(4, 1));
            
            graph[5].add(new Edge(5, 0));
            graph[5].add(new Edge(5, 2));
        }
    
        public static void main(String[] args) {
    
    
            /*      
             *      5----->0<----4
             *      |      |     |    
             *      |      |     |
             *      *      *     *
             *      2----->3---->1
             * 
             * 
             */
    
            int v = 6;
            ArrayList<Edge>[] graph = new ArrayList[v];
            createGraph(graph);
            

            int src =5; int dest = 1;
            printAllPaths(graph, src, dest, "");
             
        }

        //O(V^V)
        public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, String path){
            if(src == dest){
                System.out.println(path+dest);
            }

            for(int i=0; i<graph[src].size(); i++){
                Edge e = graph[src].get(i);

                printAllPaths(graph, e.dest, dest, path+src);
            }
        }


    
}
