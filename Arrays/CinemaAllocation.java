import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CinemaAllocation {
    
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        Map<Integer , Set<Integer>> mpp = new HashMap<>();

        for(int i=0;i<reservedSeats.length;i++){

            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];

            if(!mpp.containsKey(row)){

                mpp.put(row , new HashSet<>());

            }

            mpp.get(row).add(col);

        }

        int result = (n - mpp.size()) * 2;

        for(Set<Integer> st : mpp.values()){

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for(int i=2;i<=5;i++){
                if(st.contains(i)){
                    left = false;
                    break;
                }
            }

            for(int i=4;i<=7;i++){
                if(st.contains(i)){
                    middle = false;
                    break;
                }
            }

            for(int i=6;i<=9;i++){
                if(st.contains(i)){
                    right = false;
                    break;
                }
            }

            if(left && right) result = result + 2;
            else if(left || middle || right) result++;

        }

        return result;

    }
}
