import java.util.ArrayList;

public class MergeTwoMaxSteps {
    
    public static void swap(ArrayList<Integer> ans , int a , int b){

        int temp = ans.get(a);
        ans.set(a , ans.get(b));
        ans.set(b , temp);

    }

    public static void heapify(ArrayList<Integer> ans , int n , int i){

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && ans.get(largest) < ans.get(left)){
            largest = left;
        }

        if(right < n && ans.get(largest) < ans.get(right)){
            largest = right;
        }

        if(largest != i){
            swap(ans , largest , i);
            heapify(ans , n , largest);
        }

    }

    public static ArrayList<Integer> mergeHeap(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for(int ele : arr1){
            ans.add(ele);
        }

        for(int ele : arr2){
            ans.add(ele);
        }

        int n = ans.size();

        for(int i=n/2-1;i>=0;i--){
            heapify(ans , n , i);
        }

        return ans;


    }
    
}
