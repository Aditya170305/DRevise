import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleI {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){

            adj.add(new ArrayList<>());

        }

        for(int i=0;i<prerequisites.length;i++){

            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            adj.get(u).add(v);

        }

        int indegree [] = new int [numCourses];

        for(int i=0;i<numCourses;i++){

            for(int it : adj.get(i)){

                indegree[it]++;

            }

        }

        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=0;i<numCourses;i++){

            if(indegree[i] == 0) q.offer(i);

        }

        int count = 0;

        while(!q.isEmpty()){

            int node = q.poll();
            count++;

            for(int it : adj.get(node)){

                indegree[it]--;

                if(indegree[it] == 0){

                    q.offer(it);

                }

            }

        }

        return (count == numCourses);

    }
    
}
