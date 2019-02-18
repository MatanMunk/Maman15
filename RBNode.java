public class RBNode<T> {
    private enum RBColor{
        Red, Black
    }
    private RBNode root;
    private RBNode left;
    private RBNode right;
    private RBColor color; // 0 is black, 1 is red
    private double key;
    private T data;

    public RBNode(double key, T data) {
        this.key = key;
        this.data = data;
    }

    public RBNode(RBNode root) {
        this.root = root;
        this.color = RBColor.Black;
    }

    public void setRoot(RBNode root){
        this.root = root;
    }

    public void setLeft(RBNode left){
        this.left = left;
    }

    public void setRight(RBNode right){
        this.right = right;
    }

    public void setKey(double key){
        this.key = key;
    }

    public void setData(T data){
        this.data = data;
    }

    public RBNode getRoot(){
        return this.root;
    }

    public RBNode getLeft(){
        return this.left;
    }

    public RBNode getRight(){
        return this.right;
    }

    public double getKey(){
        return this.key;
    }

    public T getData(){
        return this.data;
    }
}
