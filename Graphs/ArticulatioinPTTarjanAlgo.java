package Graphs;

import java.util.ArrayList;

public class ArticulatioinPTTarjanAlgo {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
    }

    public static void getArticulationPoint(ArrayList<Edge> graph[], int v){
        int discovery_time[] = new int[v];
        int lowest_discovery_time[] = new int[v];
        boolean vis[] = new boolean[v];
        int time =0;

        for(int i=0; i<v; i++){
            if(!vis[i]){
                dfs(graph, i, -1, discovery_time, lowest_discovery_time, vis, time);
            }
        }
    }

    private static void dfs(ArrayList<Edge>[] graph, int curr, int par, int[] discovery_time, int[] lowest_discovery_time,
        boolean[] vis, int time) {
        vis[curr] = true;
        discovery_time[curr] = lowest_discovery_time[curr] = ++time;
        int children = 0;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            int neighbour = e.dest;

            if(neighbour == par){
                continue;
            }else if (vis[neighbour]) {
                lowest_discovery_time[curr] = Math.min(lowest_discovery_time[curr], discovery_time[neighbour]);
                // if(discovery_time[curr] < lowest_discovery_time[neighbour]){
                //     System.out.println("Bridge Edge " + curr + "----> " + neighbour);
                // }
            }else{
                dfs(graph, neighbour, curr, discovery_time, lowest_discovery_time, vis, time);
                lowest_discovery_time[curr] = Math.min(lowest_discovery_time[curr], lowest_discovery_time[neighbour]);
                if(par != -1 && discovery_time[curr] <= lowest_discovery_time[neighbour]){
                    System.out.println("Articulation point is: " + curr);
                }
                children++;
            }
        }
        if(par == -1 && children>1){
            System.out.println("Articulation point is: " + curr);
        }
    }  
    public static void main(String[] args) {
        int v =5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        getArticulationPoint(graph, v);
        

        
    }
    
}
