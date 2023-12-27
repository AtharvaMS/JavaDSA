package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class TopologicalSort {
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
            // graph[0].add(new Edge(0, 2));
    
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
             *      5---->0<----4
             *      |           |    
             *      |           |
             *      *           *
             *      2----->3---->1
             * 
             * 
             */
    
            int v = 6;
            ArrayList<Edge>[] graph = new ArrayList[v];
            createGraph(graph);
            // topSort(graph);
            topSortBFS(graph);
    
             
        }


        // Topological sort using DFS. 
        private static void topSort(ArrayList<Edge>[] graph) {
            boolean vis[] = new boolean[graph.length];
            Stack<Integer> s = new Stack<>();

            for(int i=0;i<graph.length; i++){
                if(!vis[i]){
                    topSortUtil(graph, i, vis, s); // modify dfs
                }

            }

            while (!s.isEmpty()) {
                System.out.print(s.pop()+ " ");
                
            }
            
        }

        private static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
            vis[curr] = true;
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if (!vis[e.dest]) {
                    topSortUtil(graph, e.dest, vis, s);
                    
                }
            }

            s.push(curr);

        }

        public static void calcIndegree(ArrayList<Edge> graph[], int[] indeg){
            for(int i=0; i<graph.length; i++){
                int v = i;
                for(int j=0; j<graph[v].size(); j++){
                    Edge e = graph[v].get(j);
                    indeg[e.dest]++;
                }
            }
        }
    
        public static void topSortBFS(ArrayList<Edge> graph[]){
            int indeg[] = new int[graph.length];
            Queue<Integer> q = new LinkedList<>();

            calcIndegree(graph, indeg);

            for(int i=0; i<indeg.length;i++){
                if(indeg[i] ==0){
                    q.add(i);
                }
            }

            //BFS

            while (!q.isEmpty()) {
                int curr =q.remove();
                System.out.print(curr +" ");

                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    indeg[e.dest]--;
                    if(indeg[e.dest] == 0){
                        q.add(e.dest);
                    }

                }
                
            }
        
            System.out.println();
        
        }
}
