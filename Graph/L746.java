package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {

    public int dist;
    public int node;

    public Pair(int dist , int node){

        this.dist = dist;
        this.node = node;

    }
}

public class L746 {

    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=1;i<=n+1;i++){

            adj.add(new ArrayList<>());

        }

        for(int i=0;i<times.length;i++){

            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new Pair(w , v));

        }

        int dist [] = new int [n + 1];

        Arrays.fill(dist , Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>( (x , y) -> x.dist - y.dist );

        pq.add(new Pair(0 , k));

        int time = -1;

        dist[k] = 0;

        while(!pq.isEmpty()){

            int dis = pq.peek().dist;
            int node = pq.peek().node;

            pq.poll();

            for(Pair it : adj.get(node)){

                int adjNode = it.node;
                int adjDist = it.dist;

                if(dis + adjDist < dist[adjNode]){

                    dist[adjNode] = dis + adjDist;
                    pq.add(new Pair(dist[adjNode] , adjNode));

                }
            }
        }

        for(int i=1;i<=n;i++){

            if(dist[i] == Integer.MAX_VALUE) return -1;
            time = Math.max(time , dist[i]);

        }

        return time;

    }

}
