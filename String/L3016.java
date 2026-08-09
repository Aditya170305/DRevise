package String;

import java.util.Arrays;

public class L3016 {
    
    public int minimumPushes(String word) {
        
        int n = word.length();

        if(n <= 8) return n;

        int freq [] = new int [26];

        for(int i=0;i<n;i++){

            char ch = word.charAt(i);

            freq[ch - 'a']++;

        }

        Arrays.sort(freq);

        int count = 0;
        int times = 0;
        int index = 0;

        for(int i=25;i>=0;i--){

            if(freq[i] == 0) break;

            if(index % 8 == 0) times++;
            count = count + (freq[i] * times);
            index++;

        }

        return count;

    }
}
