public class FindTheDifference {
    
    public char findTheDifference(String s, String t) {
        
        int n1 = s.length();
        int n2 = t.length();

        int freq1 [] = new int [26];
        int freq2 [] = new int [26];

        int i = 0;
        int j = 0;

        while(i < n1 || j < n2){

            if(i < n1){
                freq1[s.charAt(i) - 'a']++;
                i++;
            }

            freq2[t.charAt(j) - 'a']++;
            j++;

        }

        for(i=0;i<26;i++){

            if(freq1[i] != freq2[i]) return (char)(i + 'a');

        }

        return ' ';

    }

}
