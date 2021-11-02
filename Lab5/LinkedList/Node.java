
public class Node {
    private int data;
    private Node next;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public Node(){
        this.data = 0;
        this.next = null;
    }

    public int getData(){
      return data;
    }

    public void setNext(Node node){
        this.next = node;
    }

    public Node getNext(){
        return next;
    }
}