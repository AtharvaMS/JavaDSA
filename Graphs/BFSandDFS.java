package Graphs;

import java.util.*;



public class BFSandDFS {
    static class Edge{
        int src;
        int dest;
        
        Edge(int src, int dest){
            this.src =src;
            this.dest = dest;
        
        }
    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i =0; i<graph.length; i++){
            if(!vis[i]){
                bfsUtil(graph, vis);
            }
        }

    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]){ //O(V+E)
        Queue<Integer> q = new LinkedList();
        
        q.add(0); // source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }

            }
            
        }

    }
    
    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i =0; i<graph.length; i++){
            if(!vis[i]){
                dfsUtil(graph, vis, i);
            }
        }
    }



    public static void dfsUtil(ArrayList<Edge>[] graph, boolean vis[], int curr){
        // mark visited
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph, vis, e.dest);
            }
        }

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

        bfs(graph);
        dfs(graph);




    }
    
}
