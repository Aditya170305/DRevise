public class MinHeap {
    
    int arr [];
    int size;
    
    public MinHeap() {
        
        arr = new int [1001];
        size = 0;
        
    }
    
    public void swap(int a , int b){
        
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        
    }

    public void push(int x) {
        
        size = size + 1;
        int index = size;
        arr[index] = x;
        
        while(index > 1){
            
            int parent = index / 2;
            
            if(arr[parent] > arr[index]){
                swap(parent , index);
                index = parent;
            }
            
            else{
                return;
            }
            
        }
        
    }

    public void pop() {
        
        if(size == 0) return;
        
        swap(1 , size);
        size--;
        
        int i = 1;
        
        while(i < size){
            
            int leftIndex = 2 * i;
            int rightIndex = 2 * i + 1;
            
            int smallest = i;
            
            if(leftIndex <= size && arr[smallest] > arr[leftIndex]){
                smallest = leftIndex;
            }
            
            if(rightIndex <= size && arr[smallest] > arr[rightIndex]){
                smallest = rightIndex;
            }
            
            if(smallest != i){
                swap(smallest , i);
                i = smallest;
            }
            
            else{
                return;
            }
            
            
        }
        
    }

    public int peek() {
        
        return (size == 0) ? -1 : arr[1];
        
    }

    public int size() {
        
        return size;
        
    }
    
}
