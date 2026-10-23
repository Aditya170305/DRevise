
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Practice {
    
    public static void main(String[] args) {
        
        Map<String , Integer> mpp = new TreeMap<String , Integer>();

        mpp.put("i" , 1);
        mpp.put("love" , 1);
        mpp.put("coding" , 1);
        mpp.put("lovu" , 1);

        for(Map.Entry<String , Integer> en : mpp.entrySet()){

            String key = en.getKey();
            int val = en.getValue();

            System.out.println(key + " " + val);
        }

        Map<Integer , Integer> mpp1 = new TreeMap<Integer , Integer>(Collections.reverseOrder());

        mpp1.put(7, 1);
        mpp1.put(8, 1);
        mpp1.put(9, 10);
        mpp1.put(12, 13);

        for(Map.Entry<Integer , Integer> en : mpp1.entrySet()){

            int key = en.getKey();
            int val = en.getValue();

            System.out.println(key + " " + val);
            
        }

    }
}
