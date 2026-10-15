import java.util.List;

public class L2913 {
    
    // public int countValue(int freq []){

    //     int count = 0;

    //     for(int i=0;i<freq.length;i++){

    //         if(freq[i] > 0) count++;

    //     }

    //     return count;

    // }

    public int sumCounts(List<Integer> nums) {
        
        int score = 0;

        for(int i=0;i<nums.size();i++){

            int freq [] = new int [101];

            int count = 0;

            for(int j=i;j<nums.size();j++){

                int val = nums.get(j);
                if(freq[val] == 0){
                    count++;
                    freq[val] = 1;
                }

                score = score + (count * count);

            }

        }

        return score;

    }
    
}
