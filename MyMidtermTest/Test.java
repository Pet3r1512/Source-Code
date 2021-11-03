public class Test {
    public static void main (String[] args) {
        IntLinkedList list = new IntLinkedList();
        list.addFirst(5);
        list.addFirst(3);
        list.addFirst(1);
        list.addFirst(2);
        list.print();
        System.out.println(list.search(4));
    }
}
