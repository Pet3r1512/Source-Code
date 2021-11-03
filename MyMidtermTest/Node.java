public class Node{
    private int data;
    private Node next;

    public Node(){
        this.data = 0;
        this.next = null;
    }

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public int getData(){
        return data;
    }

    public void setData(int d){
        this.data = d;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node n){
        this.next = n;
    }
}