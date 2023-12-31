package Graphs;
import java.util.*;

import Stack.reverseString;

public class CycleDetectDirected {

        static class Edge{
            int src;
            int dest;
            
            Edge(int src, int dest){
                this.src =src;
                this.dest = dest;
            
            }
        }
        
        // Cycle in directed graph. Using array to track stack calls in DFS
        public static boolean isCycle(ArrayList<Edge>[] graph){
            boolean vis[] = new boolean[graph.length];
            boolean stack[] = new boolean[graph.length];
            for(int i=0; i<graph.length;i++){
                if(!vis[i]){
                    if(isCycleUtil(graph, i, vis, stack)){
                        return true;
                    }
                }
            }
            return false;
        }
    
        private static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
            vis[curr] = true;
            stack[curr] = true;

            for( int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);

                if(stack[e.dest]){
                    return true;
                }
                if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)){
                    return true;
                }
            }
            stack[curr] = false;
            return false;
        }

        static void createGraph(ArrayList<Edge> graph[]){
            for(int i=0; i<graph.length; i++){
                graph[i] = new ArrayList<>();
            }
    
            // graph[0].add(new Edge(0, 1));
            graph[0].add(new Edge(0, 2));
    
            // graph[1].add(new Edge(1, 0));
            // graph[1].add(new Edge(1, 3));
    
            // graph[2].add(new Edge(2, 0));
            graph[2].add(new Edge(2, 4));
            
            graph[3].add(new Edge(3, 2));
            // graph[3].add(new Edge(3, 4));
            
            graph[4].add(new Edge(4, 3));
            // graph[4].add(new Edge(4, 3));
        }
    
        public static void main(String[] args) {
    
    
            /*      0----->2---->4---->3
             *             ^            |
             *             |------------|
             *      -
             * 
             * 
             * 
             */
    
            int v = 5;
            ArrayList<Edge>[] graph = new ArrayList[v];
            createGraph(graph);
            System.out.println(isCycle(graph));
    
             
        }
        
    
    
}
