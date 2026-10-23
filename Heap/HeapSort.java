

public class HeapSort {
    
    public static void swap(int arr [] , int a , int b){

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public static void heapify(int arr [] , int n , int i){

        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if(left <= n && arr[largest] < arr[left]){
            largest = left;
        }

        if(right <= n && arr[largest] < arr[right]){
            largest = right;
        }

        if(largest != i){
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int arr [] , int n){

        int size = n;

        while(size > 1){

            swap(arr, size, 1);
            size--;

            heapify(arr , size , 1);

        }
    }

    public static void main(String[] args) {
        
        int arr [] = new int [6];

        arr[0] = -1;
        arr[1] = 54;
        arr[2] = 53;
        arr[3] = 55;
        arr[4] = 52;
        arr[5] = 50;

        int n = 5;

        for(int i=n/2;i>=1;i--){
            heapify(arr, n, i);
        }

        heapSort(arr, n);

        for(int i=1;i<=n;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
