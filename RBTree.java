import javax.naming.directory.SearchResult;

public class RBTree<T> {

    //private helper SearchResult class
    private class SearchResult {

        //declaring variables
        private boolean success;
        private RBNode node;

        //constructor
        public SearchResult(boolean isSucceeded, RBNode node) {
            this.success = isSucceeded;
            this.node = node;
        }

        //getters
        public boolean isSucceeded() {
            return this.success;
        }

        public RBNode getNode() {
            return this.node;
        }
    }


    //declaring variables
    private RBNode root;

    //constructor
    public RBTree(RBNode root) {
        this.root = root;
    }


    //insert new item to the tree.
    public void insert(double key, T data) {
        insertNode(new RBNode(key, data), null);
    }

    //private function to handle insertion of a node
    private void insertNode(RBNode nodeToInsert, RBNode currentNode) {

        //if root is null (tree is empty), then insert node to the root of the tree.
        if (this.root == null) {
            this.root = nodeToInsert;
        }

        //if tree isn't empty, insert as normal
        else {
            if (currentNode == null) {
                currentNode = this.root;
            }

            //cache key to insert, left and right children
            RBNode left = currentNode.getLeft();
            RBNode right = currentNode.getRight();
            double key = nodeToInsert.getKey();
            double currentKey = currentNode.getKey();

            if (key == currentKey) {
                //TODO: insert in the inside RBtree of the node because of heights
            }

            //if key is smaller, go left
            if (key < currentNode.getKey()) {

                //if current node has left children, call insert again with left
                if (left != null) {
                    insertNode(nodeToInsert, left);
                }

                //no left child, insert to left
                else {
                    currentNode.setLeft(nodeToInsert);
                    nodeToInsert.setRoot(currentNode);
                    //TODO: change colors & rotates
                }
            }

            //key is larger, go right
            else {

                //right isn't null, insert there
                if (right != null) {
                    insertNode(nodeToInsert, right);
                }

                //right is null, insert to right
                else {
                    currentNode.setRight(nodeToInsert);
                    nodeToInsert.setRoot(currentNode);
                    //TODO: change colors & rotates
                }
            }
        }
    }

    //search for a node in the tree. returns a SearchResult object.
    public SearchResult search(RBNode node, double searchKey) {

        //if node is null, start at root
        if (node == null) {
            node = this.root;
        }

        //cache key
        double nodeKey = node.getKey();

        //if key found, return it
        if (searchKey == nodeKey) {
            return new SearchResult(true, node);
        }

        //key not found, search children if they exists or return not found if they don't
        //check if key is in left child
        else if (searchKey < nodeKey) {

            //cache left child
            RBNode left = node.getLeft();

            //if left isn't null, it exists, search there
            if (left != null) {
                return this.search(left, searchKey);
            }

            //failed search
            else {
                return new SearchResult(false, node);
            }
        }

        //key must be at right child
        else {

            //cache right child
            RBNode right = node.getRight();

            //if left isn't null, it exists, search there
            if (right != null) {
                return this.search(right, searchKey);
            }

            //failed search
            else {
                return new SearchResult(false, node);
            }
        }
    }

    //delete a node by key value
    public void delete(double key) {

        //search for the key to see if it's in the tree
        SearchResult searchResult = search(this.root, key);

        //if it's in the tree, delete it from it
        if (searchResult.isSucceeded()) {
            this.deleteNode(searchResult.getNode());
        }

        //key not in tree
        else {
            //TODO: key doesn't exists, decide how to handle it, if at all.
        }
    }

    //private function to handle deletion of a node
    private void deleteNode(RBNode node) {

        //cache variables
        RBNode left = node.getLeft();
        RBNode right = node.getRight();
        RBNode root = node.getRoot();

        //TODO: handle colors and rotates in all cases.
        //find how many children node has, then handle how to delete the node.
        switch (node.getChildrenNumber()) {

            //case 1: no children. just delete the node and disconnect from parent.
            case 0:

                //delete references from root's child (left or right) and node's root
                root.setChild(node.getSideType(), null);
                node.setRoot(null);
                break;

            //case 2: only one child. connect that child to root and disconnect connections on node.
            case 1:

                //set child RBNode for more readable code
                RBNode child;

                //if left isn't null, the child is left
                if (left != null) {
                    child = left;
                }

                //else child is right
                else {
                    child = right;
                }

                //set root as the root of child
                child.setRoot(root);

                //replace node with child for root, with the correct side
                root.setChild(node.getSideType(), child);

                //delete references from node
                node.setRoot(null);
                node.setChild(child.getSideType(), null);
                break;

            //case 3: two children exists
            case 2:
                //TODO: Check how Amiel handled this situation
                break;
            default:
                //TODO: throw error, shouldn't happen
                break;
        }
    }

    //find successor of a node
    private RBNode findSuccessor(RBNode node) {
        //TODO: find out how to find successor
        return null;
    }

    //find predecessor of a node
    private RBNode findPredecessor(RBNode node) {
        //TODO: find out how to find predecessor
        return null;
    }

    //rotate the node right
    private void rotateRight(RBNode x) {
        RBNode y = x.getLeft();
        x.setLeft(y.getRight());   //turns y's right subtree into x's left subtree
        if (y.getRight() != null)
            (y.getRight()).setRoot(x); // y's right child new parnet is x(if y really exist).

        y.setRoot(x.getRoot());        // y's new parent is x's old parent
        if (x.getRoot() == null)
            this.root = y;              // if the x did not have a parent, than he was the root of the tree, and now y is.
        else if (x == (x.getRoot()).getLeft()) //if x was left child.    
            (x.getRoot()).setLeft(y);
        else                              // if x was right child.
            (x.getRoot()).setRight(y);

        y.setRight(x);                    //x is y's right child
        x.setRoot(y);                     //y is the parent of x
    }

    //rotate the node Left
    private void rotateLeft(RBNode x) {
    }
}
