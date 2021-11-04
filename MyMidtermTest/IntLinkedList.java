import java.util.NoSuchElementException;
public class IntLinkedList implements ListInterface{
    private Node head;
    
    public IntLinkedList(){
        this.head = null;
    }

    public Node getHead(){
        if(head == null){
            throw new NoSuchElementException("The list is empty");
        }
        return head;
    }

    public void addFirst(int data){
        head = new Node(data, head);
    }

    public void print(){
        Node i = head;
        if(head == null){
            throw new NoSuchElementException("The list is empty");
        }
        System.out.print("List: " + i.getData());
        while(i.getNext() != null){
            i = i.getNext();
            System.out.print(" -> " + i.getData());
        }
        System.out.println("");
    }

    public int search(int key){
        if(head == null){
            throw new NoSuchElementException("Can't search in an empty list");
        }
        int index = 0;
        Node tmp = head;
        while(tmp.getNext() != null){
            if(tmp.getData() == key){
                return index;
            }
            index++;
            tmp = tmp.getNext();
        }
        return -1;
    }
}
