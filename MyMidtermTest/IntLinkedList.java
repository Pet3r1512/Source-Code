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

    public boolean addAfterFirstKey(int data, int key){
        if(head == null){
            throw new NoSuchElementException("The list is empty");
        }
        Node tmp = new Node(data, head);
        for(Node curr = head; curr.getNext() != null; curr = curr.getNext()){
            if(curr.getData() == key){
                tmp.setNext(curr.getNext());
                curr.setNext(tmp);
                return true;
            }
        }
        return false;
    }

    public int compare(int item1, int item2){
        int tmp = item1 - item2;
        if(tmp > 0){
            return 1;
        }
        else if( tmp < 0){
            return -1;
        }
        else{
            return 0;
        }
    }

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
