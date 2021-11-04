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
                return true;
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
        if(head == null){
            throw new NoSuchElementException("The list is empty");
        }
        Node curr = head, index = null;
        while(curr.getNext() != null){
            index = curr.getNext();
            while(index.getNext() != null){
                if(compare(curr.getData(), index.getData()) > 0){
                    int tmp = curr.getData();
                    curr.setData(index.getData());
                    index.setData(tmp);
                }
                index = index.getNext();
            }
            curr = curr.getNext();
        }
    }
    
    @Override
    public void removeAfter(int curr){
        if(head == null){
            throw new NoSuchElementException("The list is empty");
        }
        Node tmp = head;
        while(tmp.getNext() != null){
            if(tmp.getData() == curr){
                tmp.setNext(tmp.getNext().getNext());
            }
            tmp = tmp.getNext();
        }
    }

    @Override
    public void removeFirst(){
        if(head == null){
            throw new NoSuchElementException("Can't remove from an empty list");
        }
        Node tmp = head;
        head = head.getNext();
        numNode--;
    }

    @Override
    public void removeLast(){
        if(head == null){
            throw new NoSuchElementException("Can't remove from an empty list");
        }
        Node delNode = head, preNode = null;
        while(delNode.getNext() != null){
            preNode = delNode;
            delNode = delNode.getNext();
        }
        preNode.setNext(delNode.getNext());
        delNode.setNext(null);
        numNode--;
    }
}
