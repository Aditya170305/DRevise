import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SubsetSum2 {
    
    public static void subsetSum(int index , int arr [] , ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> ds){

        ans.add(new ArrayList<>(ds));

        for(int i=index;i<arr.length;i++){

            if(i > index && arr[i] == arr[i - 1]) continue;
            ds.add(arr[index]);
            subsetSum(index + 1, arr, ans, ds);
            ds.remove(ds.size() - 1);

        }
    }

    public static void main(String[] args) {
        
        int n;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int arr [] = new int [n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);

        subsetSum(0 , arr , ans , new ArrayList<>());

        System.out.println(ans);
    }
}
