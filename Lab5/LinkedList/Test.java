
public class Test {
    public static void main (String[] args) {
        IntLinkedList list = new IntLinkedList();
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(-1);
        list.print();
        System.out.println(list.removeAt(1));
        list.print();
        // System.out.println("Number of odd elements: " + list.countOdd());
        // if(list.checkSorted() == true){
        //     System.out.println("The list is sorted");
        // }
        // else{
        //     System.out.println("The list is not sorted");
        // }
    }
}
