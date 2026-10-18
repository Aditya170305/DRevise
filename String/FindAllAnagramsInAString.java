import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    
    public List<Integer> findAnagrams(String s, String p) {
        
        int n1 = s.length();
        int n2 = p.length();

        int freq1 [] = new int [26];
        int freq2 [] = new int [26];

        for(int i=0;i<n2;i++){
            freq2[p.charAt(i) - 'a']++;
        }

        int l = 0 , r = 0;

        List<Integer> ans = new ArrayList<Integer>();

        while(r < n1){

            freq1[s.charAt(r) - 'a']++;

            if((r - l + 1) == n2){

                boolean flag = true;

                for(int i=0;i<26;i++){

                    if(freq1[i] != freq2[i]){

                        flag = false;
                        break;
                    }

                }

                if(flag) ans.add(l);
                freq1[s.charAt(l) - 'a']--;
                l++;

            }

            r++;

        }

        return ans;
        
    }
    
}
