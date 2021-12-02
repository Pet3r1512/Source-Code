import java.util.NoSuchElementException;

public class MaxHeap {
    private int[] heap;
    private int maxSize;
    private int heapSize;
    public MaxHeap(int capacity){
        this.maxSize= capacity+1;
        this.heapSize=0;
        this.heap= new int[maxSize];
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
        if (heapSize==maxSize){
            throw new RuntimeException("Maximum capacity reached");
        }
        heapSize+=1;
        heap[heapSize]=key;
        shiftUp(heapSize);
    }
    private void shiftUp(int i){
        while (i>1 &&heap[parent(i)]<heap[i]){
            swap(parent(i),i);
            i=parent(i);
        }
    }
    public int extractMax(){
        if (heapSize==0){
            throw new NoSuchElementException("The heap is empty");
        }
        int max=heap[1];
        heap[1]=heap[heapSize];
        heapSize-=1;
        shiftDown(1);
        return max;
    }
    private void shiftDown(int i){
        while (i<= heapSize){
            int max =heap[i];
            int max_ID=i;
            if (left(i)<=heapSize&&max<heap[left(i)]){
                max=heap[left(i)];
                max_ID=left(i);
            }
            if (right(i)<=heapSize&&max<heap[right(i)]){
                max=heap[right(i)];
                max_ID=right(i);
            }
            if (i!=max_ID){
                swap(i,max_ID);
                i=max_ID;
            }
            else {
                break;
            }
        }
    }
    public void print(){
        for (int i=0;i<=heapSize;i++){
            System.out.print(heap[i]+"    ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MaxHeap maxHeap= new MaxHeap(15);
        maxHeap.insert(19);
        maxHeap.insert(17);
        maxHeap.insert(3);
        maxHeap.insert(84);
        maxHeap.insert(5);
        maxHeap.insert(100);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.insert(21);
        
        maxHeap.print();
    }
}