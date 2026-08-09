package String;

public class L3014 {    

   public int minimumPushes(String word) {
        
        int n = word.length();

        if(n <= 8) return n;

        int count = 0;
        int times = 1;

        for(int i=8;i<n;i++){

            if(i % 8 == 0) times++;
            count = count + times;

        }

        return count + 8;

    }
}
