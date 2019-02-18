import javax.naming.directory.SearchResult;

public class RBTree {

    //private class
    private class SearchResult{
        private boolean success;
        private RBNode node;

        public SearchResult(boolean isSucceeded, RBNode node){
            this.success = isSucceeded;
            this.node = node;
        }

        public boolean isSucceeded(){
            return this.success;
        }

        public RBNode getNode(){
            return this.node;
        }
    }

    private RBNode root;

    public RBTree(RBNode root) {
        this.root = root;
    }

    public void insert(RBNode nodeToInsert, RBNode treeNode){
        if (this.root == null) {
            this.root = nodeToInsert;
        }
        else{
            if (treeNode == null){
                treeNode = this.root;
            }

            //cache key to insert, left and right children
            RBNode left = treeNode.getLeft();
            RBNode right = treeNode.getRight();
            double key = nodeToInsert.getKey();
            double treeKey = treeNode.getKey();

            if (key == treeKey){
                //TODO: insert in the inside RBtree of the node because of heights
            }

            //if key is smaller, go left
            if (key < treeNode.getKey())
            {

                //if current node has left children, call insert again with left
                if (left != null){
                    insert(nodeToInsert, left);
                }

                //no left child, insert to left
                else{
                    treeNode.setLeft(nodeToInsert);
                    nodeToInsert.setRoot(treeNode);
                    //TODO: change colors & rotates
                }
            }

            //key is larger, go right
            else{

                //right isn't null, insert there
                if (right != null){
                    insert(nodeToInsert, right);
                }

                //right is null, insert to right
                else{
                    treeNode.setRight(nodeToInsert);
                    nodeToInsert.setRoot(treeNode);
                    //TODO: change colors & rotates
                }
            }
        }
    }

    public SearchResult search(RBNode node, double searchKey){

        //if node is null, start at root
        if (node == null){
            node = this.root;
        }

        //cache key
        double nodeKey = node.getKey();

        //if key found, return it
        if (searchKey == nodeKey){
            return new SearchResult(true, node);
        }

        //key not found, search children if they exists or return not found if they don't
        //check if key is in left child
        else if (searchKey < nodeKey){

            //cache left child
            RBNode left = node.getLeft();

            //if left isn't null, it exists, search there
            if (left != null) {
                return this.search(left, searchKey);
            }

            //failed search
            else{
                return new SearchResult(false, node);
            }
        }

        //key must be at right child
        else{

            //cache right child
            RBNode right = node.getRight();

            //if left isn't null, it exists, search there
            if (right != null) {
                return this.search(right, searchKey);
            }

            //failed search
            else{
                return new SearchResult(false, node);
            }
        }
    }

    public void delete(RBNode node){
        //TODO: 3 casses

        //cache variables
        RBNode left = node.getLeft();
        RBNode right = node.getRight();

        //case 1: no children. just delete the node and disconnect from parent.
        if (left == null && right == null){
            node.getRoot()
        }


    }

    private RBNode findSuccessor(RBNode node){
    }

    private RBNode findPredaccesor(RBNode node){

    }

    private void rotateRight(RBNode node){

    }

    private void rotateLeft(RBNode node){

    }
}
