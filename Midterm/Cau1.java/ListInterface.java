interface  ListInterface {
    public int getHead();
    public void addFirst(int data);
    public void print();
    public boolean addAfterFirstKey(int data, int key);
    public int compare(int item1, int item2);
    public void sort();
    public void removeAfter(int curr);
    public void removeFirst();
    public void removeLast();
}
