
import java.util.NoSuchElementException;
public class IntLinkedList implements ListInterface {
    private Node head;
    private int numNode;

    public IntLinkedList(){
        this.head = null;
        this.numNode = 0;
    }

    @Override
    public void addFirst(int data){
        head = new Node(data, head);
        numNode++;
    }

    @Override
    public boolean addLast(int data){
        // If the list is empty then addLast = addFirst
        if(head == null){
            addFirst(data);
        }
        Node tmp = head;
        //If the list is not empty, then loop until tmp is the last item
        while(tmp.getNext() != null){
            tmp = tmp.getNext();
            if(tmp.getData() == data){
                return false;
            }
        }
        Node newNode = new Node(data, null);//Create a new Node
        tmp.setNext(newNode);//set the next Node of tmp Node is new Node then increse the size of the list by 1
        numNode++;
        return true;
    }

    @Override
    public boolean removeAt(int pos){
        int run = 1;
        boolean stop = true;
        Node tmp = head;
        if(head == null || pos > numNode){
            stop = false;
        }
        if(pos == 1){
            head = tmp.getNext();
        }
        while(tmp.getNext() != null){
            if(run+1 == pos){
                tmp.setNext(tmp.getNext().getNext());
                numNode--;
            }
            run++;
            tmp = tmp.getNext();
            stop = true;
        }
        return stop;
    }

    @Override
    public int countOdd(){
        Node tmp = head;
        int c=0;
        if(head == null){
            throw new NoSuchElementException("Can't count odd elements from an empty list");
        }
        while(tmp.getNext() != null){//for(tmp= head,tmp.getNext() != null; tmp = tmp.getNext() )
            tmp = tmp.getNext();
            if(tmp.getData()%2 != 0){
                c++;
            }
        }
        return c;
    }

    @Override
    public boolean checkSorted(){
        Node tmp = head;
        if(head == null){
            throw new NoSuchElementException("Can't check an empty list");
        }
        for(tmp = head; tmp.getNext() != null; tmp = tmp.getNext()){
            if(tmp.getData() <= tmp.getNext().getData()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void print(){
        Node print = head;
        if(head == null){
            throw new NoSuchElementException("Can't print a empty list");
        }
        System.out.print("List: " + print.getData());
        while(print.getNext() != null){
            print = print.getNext();
            System.out.print(" -> " + print.getData());
        }
        System.out.println("");
    }
}
