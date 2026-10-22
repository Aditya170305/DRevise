public class HeapImplementation {

    public int arr [];
    public int size;

    public HeapImplementation(){

        this.arr = new int [100];
        this.size = 0;

    }

    public void swap(int a , int b){

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public void insertion(int value){

        size = size + 1;
        int index = size;
        arr[index] = value;

        while(index > 1){

            int parent = index / 2;

            if(arr[parent] < arr[index]){
                swap(parent, index);
                index = parent;
            }

            else{
                return;
            }

        }
    }

    public void deletion(){

        if(size == 0){
            System.out.println("Nothing To Delete");
            return;
        }

        swap(1 , size);
        size--;

        int i = 1;

        while(i < size){

            int leftIndex = 2 * i;
            int rightIndex = 2 * i + 1;

            if(leftIndex <= size && arr[i] < arr[leftIndex]){
                swap(leftIndex, i);
                i = leftIndex;
            }

            else if(rightIndex <= size && arr[i] < arr[rightIndex]){
                swap(rightIndex, i);
                i = rightIndex;
            }

            else{
                return;
            }

        }

    }

    public static void heapify(int [] arr , int n , int i){

        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if(left <= n && arr[largest] < arr[left]){
            largest = left;
        }

        else if(right <= n && arr[largest] < arr[right]){
            largest = right;
        }

        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, n, largest);
        }
    }

    public void printArray(){

        for(int i=1;i<=size;i++){
            System.out.print(arr[i] + " ");
        }

    }
    
    public static void main(String[] args) {
        
        HeapImplementation h = new HeapImplementation();

        h.insertion(50);
        h.insertion(55);
        h.insertion(53);
        h.insertion(52);
        h.insertion(54);

        System.out.println("Before Deletion");

        h.printArray();

        h.deletion();

        System.out.println();

        System.out.println("After Deletion");

        h.printArray();

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

        System.out.println("Printing The Array Now : ");

        for(int i=1;i<=n;i++){
            System.out.print(arr[i] + " ");
        }


    }
}
