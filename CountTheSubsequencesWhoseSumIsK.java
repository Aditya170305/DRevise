import java.util.ArrayList;
import java.util.Scanner;

public class CountTheSubsequencesWhoseSumIsK {
    
    public static int subsequencesSum(int index , int arr [] , int sum , int k){

        if(index == arr.length){

            if(sum == k){
                return 1;
            }

            return 0;
        }

        // ans.add(arr[index]);
        sum = sum + arr[index];

        int l = subsequencesSum(index + 1 , arr , sum , k);

        // ans.remove(ans.size() - 1);
        sum = sum - arr[index];

        int r = subsequencesSum(index + 1 , arr , sum , k);

        return l + r;
    }
    
    public static void main(String [] args){

        int n;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int arr [] = new int [n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        // ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        System.out.println(subsequencesSum(0, arr , 0 , k));
    }
}
