import java.util.ArrayList;
import java.util.Scanner;

public class PrintSubsequencesWhoseSumIsK {

    public static void subsequencesSum(int index , int arr [] , ArrayList<Integer> ans , int sum , int k){

        if(index == arr.length){

            if(sum == k){
                System.out.println(ans);
            }

            return;
        }

        ans.add(arr[index]);
        sum = sum + arr[index];

        subsequencesSum(index + 1 , arr , ans , sum , k);

        ans.remove(ans.size() - 1);
        sum = sum - arr[index];

        subsequencesSum(index + 1 , arr , ans , sum , k);
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
        subsequencesSum(0, arr, new ArrayList<>() , 0 , k);
    }
}
