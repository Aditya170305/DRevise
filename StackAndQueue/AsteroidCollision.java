import java.util.ArrayList;
import java.util.List;

public class AsteroidCollision {
    
    public int[] asteroidCollision(int[] asteroids) {
        
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<asteroids.length;i++){

            if(asteroids[i] > 0) list.add(asteroids[i]);

            else{

                while(!list.isEmpty() && list.getLast() > 0 && list.getLast() < Math.abs(asteroids[i])){
                    list.remove(list.size() - 1);
                }

                if(!list.isEmpty() && list.getLast() == Math.abs(asteroids[i])) list.remove(list.size() - 1);

                else if(list.isEmpty() || list.getLast() < 0){
                    list.add(asteroids[i]);
                }

            }

        }

        int ans [] = new int [list.size()];
        int index = 0;
        for(Integer ele : list){
            ans[index++] = ele;
        }

        return ans;

    }
    
}
