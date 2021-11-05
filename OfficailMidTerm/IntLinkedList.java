import java.util.NoSuchElementException;
public class IntLinkedList implements ListInterface{
    private Node head;

    public IntLinkedList(){
        this.head = null;
    }

    public void print(){
        if(head == null){
            throw new NoSuchElementException("Can't print an empty list");
        }
        Node print = head;
        System.out.print("List: " + print.getData());
        while(print.getNext() != null){
            print = print.getNext();
            System.out.print(" -> " + print.getData());
        }
        System.out.println("");
    }

    @Override
    public Node getHead(){
        if(head == null){
            throw new NoSuchElementException("Can't get a head from an empty list");
        }
        return head;
    }

    @Override
    public void addFirst(int data){
        head = new Node(data, head);
    }

    @Override
    public int countElementSmallerThanKey(int key){
        if(head == null){
            throw new NoSuchElementException("Can't count element from an empty list");
        }
        Node tmp = head;
        int count = 0;
        while(tmp.getNext() != null){
            if(tmp.getData() < key){
                count++;
            }
            tmp = tmp.getNext();
        }
        return count;
    }
}
