import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintAllSubsequences {
    
    public static void subsequences(int index , int arr [] , ArrayList<Integer> ans){

        if(index == arr.length){

            System.out.println(ans);
            return;
        }

        ans.add(arr[index]);
        subsequences(index + 1, arr, ans);
        ans.remove(ans.size() - 1);
        subsequences(index + 1, arr, ans);
    }
    public static void main(String[] args) {
        
        int n;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int arr [] = new int [n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        // ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subsequences(0, arr, new ArrayList<>());

    }
}
