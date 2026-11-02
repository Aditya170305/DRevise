import java.util.ArrayList;
import java.util.List;

public class Combinations {
    
    public void find(int index , List<Integer> ds , int [] arr , int k , List<List<Integer>> ans){

        if(k == 0){

            ans.add(new ArrayList<> (ds));
            return;

        }

        if(index == arr.length){

            if(k == 0){

                ans.add(new ArrayList<> (ds));

            }

            return;

        }

        ds.add(arr[index]);

        find(index + 1 , ds , arr , k - 1 , ans);

        ds.remove(ds.size() - 1);

        find(index + 1 , ds , arr , k , ans);

    }

    public List<List<Integer>> combine(int n, int k) {
        
        int arr [] = new int [n + 1];

        for(int i=1;i<n+1;i++){

            arr[i] = i;

        }

        List<List<Integer>> ans = new ArrayList<>();

        find(1 , new ArrayList<>() , arr , k , ans);

        return ans;
        
    }
    
}
