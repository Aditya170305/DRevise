import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {
    
    Map<String , Integer> mpp;

    public MapSumPairs() {
        
        mpp = new HashMap<String , Integer>();

    }
    
    public void insert(String key, int val) {
        
        mpp.put(key , val);

    }
    
    public int sum(String prefix) {
        
        int sum = 0;
        for(Map.Entry<String , Integer> en : mpp.entrySet()){
            if(en.getKey().startsWith(prefix)) sum = sum + en.getValue();
        }

        return sum;

    }

}
