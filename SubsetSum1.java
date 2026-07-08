import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SubsetSum1 {

    public static void subsetSum(int index , int sum , int [] arr , List<Integer> ans){

        if(index == arr.length){
            ans.add(sum);
            return;
        }

        subsetSum(index + 1 , sum + arr[index] , arr , ans);

        subsetSum(index + 1, sum, arr, ans);
    }

    public static void main(String[] args) {
        
        int n;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int arr [] = new int [n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        List<Integer> ans = new ArrayList<>();
        subsetSum(0 , 0 , arr , ans);
        Collections.sort(ans);

        System.out.println(ans);
    }
}
