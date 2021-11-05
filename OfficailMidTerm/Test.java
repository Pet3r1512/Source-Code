public class Test {
    public static void main (String[] args) {
        IntLinkedList list = new IntLinkedList();
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(6);
        list.print();
        System.out.println("Number of element smaller than 3 is " + list.countElementSmallerThanKey(3));
    }
}
