import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentWords {
    
    public int checkLexico(String str1 , String str2){

        int i = 0;
        int found_m = 0;

        while(i < Math.min(str1.length() , str2.length())){

            if(str1.charAt(i) != str2.charAt(i)){

                if(str1.charAt(i) < str2.charAt(i)) found_m = 1;
                else found_m = 2;

            }

            i++;

        }

        return found_m;

    }

    public List<String> topKFrequent(String[] words, int k) {

        int n = words.length;
        
        Map<String , Integer> mpp = new TreeMap<String , Integer>();

        for(String str : words){

            if(mpp.containsKey(str)){
                mpp.put(str , mpp.get(str) + 1);
            }

            else{
                mpp.put(str , 1);
            }

        }

        List<String> bucket [] = new ArrayList[n + 1];

        for(Map.Entry<String , Integer> en : mpp.entrySet()){

            String str = en.getKey();
            int freq = en.getValue();

            if(bucket[freq] == null) bucket[freq] = new ArrayList<String>();
            bucket[freq].add(str);

        }

        List<String> ans = new ArrayList<String>();

        for(int i=n;i>=0;i--){

            if(k == 0) break;

            if(bucket[i] == null || bucket[i].size() == 0) continue;

            ans.add(bucket[i].get(0));
            k--;

            for(int j=1;j<bucket[i].size();j++){
                if(k == 0) break;
                ans.add(bucket[i].get(j));
                k--; 

            }

        }

        return ans;

    }
    
}
