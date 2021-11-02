public class test {
    public static void main (String[] args) {
        IntLinkedList list = new IntLinkedList();
        list.addFirst(6);
        list.addFirst(3);
        list.addFirst(5);
        list.addFirst(4);
        list.print();
        System.out.println(list.addAfterFirstKey(7, 4));
        list.print();
        list.sort();
        list.print();
    }
}
