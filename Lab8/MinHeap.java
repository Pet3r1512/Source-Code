import java.util.NoSuchElementException;

public class MinHeap {
    private int[] heap;
    private int minSize;
    private int heapSize;
    public MinHeap(int capacity){
        this.minSize= capacity+1;
        this.heapSize=0;
        this.heap= new int[minSize];
        this.heap[0]=-1;
    }
    private int parent(int i){
        return i/2;
    }
    private int left(int i){
        return 2*i;
    }
    private int right(int i){
        return 2*i+1;
    }
    private void swap(int i,int j){
        int t=heap[i];
        heap[i]=heap[j];
        heap[j]=t;
    }
    public void insert(int key){
        if (heapSize==minSize){
            throw new RuntimeException("Maximum capacity reached");
        }
        heapSize+=1;
        heap[heapSize]=key;
        shiftUp(heapSize);
    }
    private void shiftUp(int i){
        while (i>1 && heap[parent(i)]>heap[i]){
            swap(parent(i),i);
            i=parent(i);
        }
    }
    public int extractMin(){
        if (heapSize==0){
            throw new NoSuchElementException("The heap is empty");
        }
        int min=heap[1];
        heap[1]=heap[heapSize];
        heapSize-=1;
        shiftDown(1);
        return min;
    }
    private void shiftDown(int i){
        while (i<= heapSize){
            int min =heap[i];
            int min_ID=i;
            if (left(i)<=heapSize&&min>heap[left(i)]){
                min=heap[left(i)];
                min_ID=left(i);
            }
            if (right(i)<=heapSize&&min>heap[right(i)]){
                min=heap[right(i)];
                min_ID=right(i);
            }
            if (i!=min_ID){
                swap(i,min_ID);
                i=min_ID;
            }
            else {
                break;
            }
        }
    }
    public void print(){
        for (int i=0;i<=heapSize;i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MinHeap minHeap= new MinHeap(15);
        minHeap.insert(3);
        minHeap.insert(84);
        minHeap.insert(17);
        minHeap.insert(5);
        minHeap.insert(19);
        minHeap.insert(10);
        minHeap.insert(9);
        minHeap.insert(6);
        minHeap.insert(22);
        
        minHeap.print();
    }
}