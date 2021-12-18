import java.util.ArrayList;

public class AVL {
    private Node root;

    public AVL(){
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int height(Node node){		
		if (node == null) 
            return -1;   
        return node.getHeight();
	}

    private int checkBalance(Node x){
		return height(x.getLeft()) - height(x.getRight());
	}

    private Node rotateLeft(Node x){
        Node y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);

        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));

        return y;
    }

    private Node rotateRight(Node y){
        Node x = y.getLeft();
        y.setLeft(x.getRight());
        x.setRight(y);

        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));

        return x;
    }

    private Node balance(Node x) {
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        int balance = checkBalance(x);

        if(balance > 1 && x.getReceipt().getReceiptId() < x.getLeft().getReceipt().getReceiptId()){
            return rotateRight(x);
        }
        if(balance < -1 && x.getReceipt().getReceiptId() > x.getRight().getReceipt().getReceiptId()){
            return rotateLeft(x);
        }
        if(balance > 1 && x.getReceipt().getReceiptId() > x.getLeft().getReceipt().getReceiptId()){
            x.setLeft(rotateLeft(x.getLeft()));
            return rotateRight(x);
        }
        if(balance < -1 && x.getReceipt().getReceiptId() < x.getRight().getReceipt().getReceiptId()){
            x.setRight(rotateRight(x.getRight()));
            return rotateLeft(x);
        }

		return x;
	}

    private Node insert(Node node, Receipt receipt){
		//code here and change the return value
        if(node == null){
            return new Node(receipt);
        }
        if(receipt.getReceiptId() < node.getReceipt().getReceiptId()){
            node.setLeft(insert(node.getLeft(), receipt));
        }
        else if(receipt.getReceiptId() > node.getReceipt().getReceiptId()){
            node.setRight(insert(node.getRight(), receipt));
        }
		return node;
	}

    public void insertReceipt(Receipt receipt){
		this.root = insert(this.root, receipt);
	}

    private void NLR(Node node, ArrayList<String> result){
		if (node != null) 
        { 
			result.add(node.getReceipt().toString()) ; 
            NLR(node.getLeft(), result);             
            NLR(node.getRight(), result); 
        } 
	}
	
	public void NLR(ArrayList<String> result){
		NLR(this.root, result);
	}

    private Node search(Node x, int receiptId) {
		//code here and change the return value
		return null;
	}
	
	public String search(int receiptId){
		return search(root, receiptId).getReceipt().toString();
	}
}
