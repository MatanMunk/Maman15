public class RBNode<T> {
    private enum RBColor {
        Red, Black
    }

    public enum SideType {
        Left, Right
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

    public void setRoot(RBNode root) {
        this.root = root;
    }

    public void setLeft(RBNode left) {
        this.left = left;
    }

    public void setRight(RBNode right) {
        this.right = right;
    }

    public void setChild(SideType sideType, RBNode node) {
        if (sideType == SideType.Left) {
            this.setLeft(node);
        }
        if (sideType == SideType.Right) {
            this.setRight(node);
        }
    }

    public void setKey(double key) {
        this.key = key;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RBNode getRoot() {
        return this.root;
    }

    public RBNode getLeft() {
        return this.left;
    }

    public RBNode getRight() {
        return this.right;
    }

    public double getKey() {
        return this.key;
    }

    public T getData() {
        return this.data;
    }

    //find out how many children this node has. (0,1 or 2)
    public int getChildrenNumber() {
        int childrenNumber = 0;
        if (this.left != null) {
            childrenNumber++;
        }
        if (this.right != null) {
            childrenNumber++;
        }
        return childrenNumber;
    }

    //Check if the current node is a left or a right child
    public SideType getSideType() {

        //check if root is null. if it is, the node is the root of the tree
        if (this.root != null) {

            //the node is a left child
            if (this.root.left == this)
                return SideType.Left;

            //the node is a right child
            if (this.root.right == this)
                return SideType.Right;
        }

        //the node is the root of the tree, return null.
        return null;
    }
}
