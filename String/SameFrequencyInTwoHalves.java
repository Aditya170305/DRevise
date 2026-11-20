public class SameFrequencyInTwoHalves {
    
    public boolean halvesMatch(String s) {
        
        int n = s.length();
        
        int mid_index = n / 2;
        
        if(n % 2 == 1) mid_index++;
        
        int i = 0;
        
        int freq1 [] = new int [26];
        int freq2 [] = new int [26];
        
        while(mid_index + i < n){
            
            freq1[s.charAt(mid_index + i) - 'a']++;
            freq2[s.charAt(i) - 'a']++;
            i++;
            
        }
        
        for(i=0;i<26;i++){
            
            if(freq1[i] != freq2[i]) return false;
            
        }
        
        return true;
        
    }
    
}
