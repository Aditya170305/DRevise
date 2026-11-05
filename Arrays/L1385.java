import java.util.Arrays;

public class L1385 {

    public int lowerBound(int ele , int [] arr2){

        int ans = arr2.length;

        int low = 0;
        int high = arr2.length - 1;

        while(low <= high){

            int mid = (low + high) >> 1;

            if(arr2[mid] >= ele){

                ans = mid;
                high = mid - 1;

            }

            else{

                low = mid + 1;

            }

        }

        return ans;

    }
    
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        
        // int ans = 0;

        // for(int i=0;i<arr1.length;i++){

        //     int count = 0;

        //     for(int j=0;j<arr2.length;j++){

        //         if(Math.abs(arr1[i] - arr2[j]) > d) count++;
        //         else break;

        //     }

        //     if(count == arr2.length) ans++;

        // }

        // return ans;

        int ans = 0;

        Arrays.sort(arr2);

        for(int i=0;i<arr1.length;i++){

            int j = lowerBound(arr1[i] , arr2);

            if(j == 0){

                ans = ans + ((arr2[0] - arr1[i]) > d ? 1 : 0);

            }

            else if(j == arr2.length){

                ans = ans + ((arr1[i] - arr2[arr2.length - 1]) > d ? 1 : 0);

            }

            else{

                int val1 = ((arr2[j] - arr1[i]) > d ? 1 : 0);
                int val2 = ((arr1[i] - arr2[j - 1]) > d ? 1 : 0);

                if(val1 == 1 && val2 == 1) ans = ans + 1;

            }

        }

        return ans;


    }
}
