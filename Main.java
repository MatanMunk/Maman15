public class Main {
    public static void main(String[] args) {
        RBNode node1 = new RBNode(5,"e");
        RBTree T = new RBTree(node1);
        T.insert(2,"b");//				|5|
        T.insert(1,"a");//		|2|				|6|
        T.insert(3,"c");//	|1|		|3|				|7|
        T.insert(4,"d");//				|4|				|8|
        T.insert(6,"f");//									|9|
        T.insert(7,"g");//										|10|
        T.insert(8,"h");
        T.insert(9,"i");
        T.insert(10,"j");
        
        System.out.println("START:");
        System.out.println("Right Child: " + node1.getRight() + " || Left Child: " + node1.getLeft() + " || Parent: " + node1.getRoot());
        System.out.println("Right Child: " + (node1.getRight()).getKey() + " || Left Child: " + (node1.getLeft()).getKey() + " || Parent: null");
        
        T.rotateLeft(node1);
        System.out.println("After rotat Left:");
        System.out.println("Right Child: " + node1.getRight() + " || Left Child: " + node1.getLeft() + " || Parent: " + node1.getRoot());
        System.out.println("Right Child: " + /* (node1.getRight()).getKey()  + */ " || Left Child: " + (node1.getLeft()).getKey() + " || Parent: " + (node1.getRoot()).getKey());
        
        T.rotateRight(node1);
        System.out.println("After rotat Right:");
        System.out.println("Right Child: " + node1.getRight() + " || Left Child: " + node1.getLeft() + " || Parent: " + node1.getRoot());
        System.out.println("Right Child: " + /* (node1.getRight()).getKey()  + */ " || Left Child: " + (node1.getLeft()).getKey() + " || Parent: " + (node1.getRoot()).getKey());
        
        System.out.println("END");
		// my bad, its look fine, lol.
    }
}
