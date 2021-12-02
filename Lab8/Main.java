import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void heapSortAccending(int a[]){
        MinHeap heap=new MinHeap(a.length);
        for(int i=0;i<a.length;i++){
            heap.insert(a[i]);
        }
        for (int i=0;i<a.length;i++){
            a[i]=heap.extractMin();
        }
    }
    public static void heapSortDesending(int a[]){
        MaxHeap heap=new MaxHeap(a.length);
        for (int i=0;i<a.length;i++){
            heap.insert(a[i]);
        }
        for (int i=0;i<a.length;i++){
            a[i]= heap.extractMax();
        }
    }
    public static void main(String[] args) {
        int a[]={15, 23, 18, 63, 21, 35, 36, 21, 66, 12, 42, 35, 75, 23, 64, 78, 39};
        heapSortAccending(a);
        System.out.println("Theo thu tu tang dan:" + Arrays.toString(a));
        heapSortDesending(a);
        System.out.println("Theo thứ tự giam dan:" + Arrays.toString(a));

        PriorityQueue queue = new PriorityQueue(20);
        queue.enQueue(new Person("Alex",3));
        queue.enQueue(new Person("Bob",2));
        queue.enQueue(new Person("David",6));
        queue.enQueue(new Person("Susan",1));
        System.out.println(queue.deQueue());
        
        queue.enQueue(new Person("Mike",5));
        queue.enQueue(new Person("Kevin",4));
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

        queue.enQueue(new Person("Helen",0));
        queue.enQueue(new Person("Paul",8));
        queue.enQueue(new Person("Iris",7));
        System.out.println(queue.deQueue());
    }
}