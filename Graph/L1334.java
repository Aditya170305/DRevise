public class L1334 {
    
    class Pair {

    public int dist;
    public int node;

    public Pair(int dist , int node){

        this.dist = dist;
        this.node = node;

    }

}

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        //By Floyd's Warshall
        
        int dist [][] = new int [n][n];

        for(int i=0;i<n;i++){
            
            dist[i][i] = 0;

            for(int j=i+1;j<n;j++){

                dist[i][j] = Integer.MAX_VALUE;
                dist[j][i] = Integer.MAX_VALUE;

            }
        }

        for(int i=0;i<edges.length;i++){

            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            dist[u][v] = wt;
            dist[v][u] = wt;

        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){

                        dist[i][j] = Math.min(dist[i][j] , dist[i][k] + dist[k][j]);

                    }
                }
            }
        }


        int countMax = n , cityNo = -1;

        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){

                if(dist[i][j] <= distanceThreshold){

                    count++;

                }

            }

            if(count <= countMax){

                countMax = count;
                cityNo = i;

            }

        }

        return cityNo;

        //By Dijkistra's Algorithm

        // ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // for(int i=0;i<n;i++){
        //     adj.add(new ArrayList<>());
        // }

        // for(int i=0;i<edges.length;i++){

        //     int u = edges[i][0];
        //     int v = edges[i][1];
        //     int wt = edges[i][2];

        //     adj.get(u).add(new Pair(wt , v));
        //     adj.get(v).add(new Pair(wt , u));

        // }

        // PriorityQueue<Pair>pq = new PriorityQueue<Pair>( (x , y) -> x.dist - y.dist);

        // int dist [] = new int [n];

        // int countMax = n , cityNo = -1;

        // for(int k=0;k<n;k++){

        //     Arrays.fill(dist , Integer.MAX_VALUE);

        //     dist[k] = 0;
            
        //     pq.add(new Pair(0 , k));

        //     while(!pq.isEmpty()){

        //         int dis = pq.peek().dist;
        //         int node = pq.peek().node;

        //         pq.poll();

        //         for(Pair it : adj.get(node)){

        //             int adjNode = it.node;
        //             int adjDist = it.dist;

        //             if(dis + adjDist < dist[adjNode]){

        //                 dist[adjNode] = dis + adjDist;
        //                 pq.add(new Pair(dist[adjNode] , adjNode));

        //             }

        //         }
        //     }

        //     int count = 0;

        //     for(int i=0;i<n;i++){

        //         if(dist[i] <= distanceThreshold){
        //             count++;
        //         }
        //     }

        //     if(count <= countMax){
        //         countMax = count;
        //         cityNo = k;
        //     }

        // }

        // return cityNo;

    }
}
}
