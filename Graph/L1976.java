package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {

    public long dist;
    public int node;

    public Pair(long dist , int node){

        this.dist = dist;
        this.node = node;

    }
}

public class L1976 {

    public int countPaths(int n, int[][] roads) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){

            adj.add(new ArrayList<>());

        }

        for(int i=0;i<roads.length;i++){

            int u = roads[i][0];
            int v = roads[i][1];
            int dist = roads[i][2];

            adj.get(u).add(new Pair(dist , v));
            adj.get(v).add(new Pair(dist , u));

        }

        long dist [] = new long [n];
        long ways [] = new long [n];

        Arrays.fill(dist , Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>( (x , y) -> Long.compare(x.dist , y.dist) );
        pq.add(new Pair(0 , 0));
        int mod = ((int)1e9 + 7);

        while(!pq.isEmpty()){

            long dis = pq.peek().dist;
            int node = pq.peek().node;

            pq.poll();

            for(Pair it : adj.get(node)){

                int adjNode = it.node;
                long adjDist = it.dist;

                if(dis + adjDist < dist[adjNode]){

                    dist[adjNode] = dis + adjDist;
                    pq.add(new Pair(dist[adjNode] , adjNode));
                    ways[adjNode] = ways[node];

                }

                else if(dis + adjDist == dist[adjNode]){

                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;

                }
            }
        }

        return (int)ways[n - 1] % mod;

    }
}
