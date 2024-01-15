package Graphs;

import java.util.ArrayList;
import java.util.Collections;


public class KruskalsAlgo {


    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));

    }

    static int n = 4; // vertices
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i=0; i<parent.length; i++){
            parent[i] =i;
            rank[i] =0;
        }
    }

    public static int find(int x){
        if( x == parent[x]){
            return x;
        }

        //path compression
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            parent[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] < rank[parB]){
            parent[parA] = parB;
        }else {
            parent[parB] = parA;
        }


    }

    //O(v + ElogE)
    public static void kruskal(ArrayList<Edge> edges, int v){
        init();
        //sorting
        Collections.sort(edges); //O(ElogE)
        
        int count = 0;
        int mstCost =0;

        for(int i=0; count<v-1; i++){ //O(V)
            Edge e = edges.get(i); //(src, dest, wt)
            
            int parA = find(e.src); // src = a
            int parB = find(e.dest); // dest = b

            if(parA != parB){
                mstCost += e.weight;
                union(e.src, e.dest);
                count++;
            }

        }
        System.out.println(mstCost);


    }


    public static void main(String[] args) {
        int n = 4;
        ArrayList<Edge> edges =  new ArrayList<>();
        createGraph(edges);
        kruskal(edges, n);
        
    }
    
}
