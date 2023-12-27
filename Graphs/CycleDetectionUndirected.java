package Graphs;

import java.util.ArrayList;

import Stack.reverseString;

public class CycleDetectionUndirected {
    static class Edge{
        int src;
        int dest;
        
        Edge(int src, int dest){
            this.src =src;
            this.dest = dest;
        
        }
    }

    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for( int i=0; i<graph.length; i++)
        {
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, i, -1)){
                    return true;

                    // cycle exist in one of the parts
                }

            }
        }
        return false;
    }





    private static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
        vis[curr] = true;

        for(int i=0; i< graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            // case 3
            if(!vis[e.dest]){
                if(detectCycleUtil(graph, vis, e.dest, curr)){
                    return true;
                }
            }
            // case 1
            else if(vis[e.dest] && e.dest != par){
                return true;
            }
            // case 3 -> no action
        }

        return false;
    }





    public static void main(String[] args) {

         /*
         * 
         *         1 ---- 3
         *       /        |   \
         *      0         |     5 ---- 6
         *       \        |   /
         *         2 ---- 4
         * 
         * 
         * 
         * 
         */

        int v =7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 0 vertex
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        //1 vertex
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        //2 vertex
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        //3 vertex
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        //4 vertex
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        //5 vertex
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        //6 vertex
        graph[6].add(new Edge(6,5));

        System.out.println(isCycle(graph));
        
    }
    
}
