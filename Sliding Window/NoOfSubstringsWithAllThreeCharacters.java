import java.util.Arrays;

public class NoOfSubstringsWithAllThreeCharacters {
    
    public static int countSubstring(String s){
        
        // int count = 0;

        // for(int i=0;i<s.length();i++){

        //     int hash [] = new int [3];

        //     for(int j=i;j<s.length();j++){

        //         hash[s.charAt(j) - 'a']++;

        //         if(hash[0] > 0 && hash[1] > 0 && hash[2] > 0){
        //             count = count + (s.length() - j);
        //             break;
        //         }
        //     }

        // }

        // return count;

        int count = 0;

        int lastSeen [] = new int [3];

        Arrays.fill(lastSeen , -1);

        for(int i=0;i<s.length();i++){

            lastSeen[s.charAt(i) - 'a'] = i;

            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                count = count + (1 + Math.min(lastSeen[0] , Math.min(lastSeen[1] , lastSeen[2])));
            }
        }

        return count;
        
    }
}
