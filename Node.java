class Node {
    private Receipt receipt;
    private Node left;
    private Node right;
    private int height;

    public Node (Receipt receipt){
        this.receipt = receipt;
    }

    public Receipt getReceipt(){
        return receipt;
    }

    public void setReceipt(Receipt newReceipt){
        this.receipt = newReceipt;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int h) {
        this.height = h;
    }
}