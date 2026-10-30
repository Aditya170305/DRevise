import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {

    int adj;
    int wt;

    public Pair(int adj , int wt){

        this.adj = adj;
        this.wt = wt;

    }

}

class Tuple {

    int dist;
    int node;
    int count;

    public Tuple(int dist , int node , int count){

        this.dist = dist;
        this.node = node;
        this.count = count;

    }

}

public class L3790 {
    
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){

            adj.add(new ArrayList<>());

        }

        for(int i=0;i<edges.length;i++){

            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            Pair p = new Pair(v , wt);

            adj.get(u).add(p);

        }

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(( a , b ) -> a.dist - b.dist);

        int dist [][] = new int [n][k + 1];

        for(int i=0;i<n;i++){
            Arrays.fill(dist[i] , Integer.MAX_VALUE);
        }

        dist[0][1] = 0;

        pq.offer(new Tuple(0 , 0 , 1));

        while(!pq.isEmpty()){

            Tuple t = pq.poll();
            int distance = t.dist;
            int node = t.node;
            int count = t.count;

            if(node == n-1) return distance;

            for(Pair it : adj.get(node)){

                int adjNode = it.adj;
                int wt = it.wt;

                int newCount = (labels.charAt(adjNode) == labels.charAt(node)) ? count + 1 : 1;

                if(newCount > k) continue;

                int newDist = distance + wt;

                if(newDist < dist[adjNode][newCount]){
                    dist[adjNode][newCount] = newDist;
                    Tuple new_t = new Tuple(newDist , adjNode , newCount);
                    pq.offer(new_t);
                }

            }

        }

        return -1;

    }

}
