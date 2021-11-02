import java.util.NoSuchElementException;

public class IntLinkedList implements ListInterface{
    private Node head;
    private int numNode;
    
    public IntLinkedList(){
        this.head = null;
    }

    @Override
    public int getHead(){
        if(head == null){
            throw new NoSuchElementException("Can't get an element from an empty list");
        }
        return head.getData();
    }

    @Override
    public void addFirst(int data){
        head = new Node(data, head);
        numNode++;
    }

    @Override
    public void print(){//int[] double[] for int =0; i<size; i++
        Node i = head;//int i=0
        if(head == null){
            throw new NoSuchElementException("The list is empty");
        }
        System.out.print("The list: " + i.getData());
        while(i.getNext() != null){
            i = i.getNext();//i++
            System.out.print(" -> " + i.getData());
        }
        System.out.println("");
    }

    // @Override
    // public boolean addAfterFirstKey(int data, int key){
    //     Node tmp  = new Node(data, head), curr = head;
    //     while(curr.getNext() != null){
    //         if(curr.getData() == key){
    //             tmp.setNext(curr.getNext());
    //             curr.setNext(tmp);
    //             return true;
    //         }
    //         curr =  curr.getNext();
    //     }
    //     return false;
    // }

    @Override
    public boolean addAfterFirstKey(int data, int key){//2 3 4 9 5        (9,4) key = 4, data = 9
        Node tmp = new Node(data, head);
        // while(curr.getNext() != null){
        //     if(curr.getData() == key){
        //         tmp.setNext(curr.getNext());
        //         curr.setNext(tmp);
        //         return true;
        //     }
        //     curr = curr.getNext(); // = curr++
        // }
        for(Node curr = head; curr.getNext() != null; curr = curr.getNext()){
            if(curr.getData() == key){
                tmp.setNext(curr.getNext());
                curr.setNext(tmp);
            }
        }
        return false;
    }

    @Override
    public int compare(int item1, int item2){
        int tmp = item1 - item2;
        if(tmp > 0){
            return 1;
        }
        if(tmp < 0){
            return -1;
        }
        return 0;
    }

    @Override
    public void sort(){
        Node curr = head, index = null;
        int tmp;
        if(head == null){
            throw new NoSuchElementException("Can't sort an empty list");
        }
        while(curr != null){
            index = curr.getNext();// index = gia tri next cua curr
            while(index != null){
                if(compare(curr.getData(), index.getData()) == -1){
                    tmp = curr.getData();//tmp = curr
                    curr.setData(index.getData());//curr = index
                    index.setData(tmp);//index = tmp
                }
                index = index.getNext();//index++
            }
            curr = curr.getNext();//curr++
        }
    }
}