package base;

// Main Class: For creating BST and taking user input
public class Main {

    public static void main(String[] args) {
        // Initialization of BST
        var newBST = new BST(0);

        // Adding elements to BST ("newBST")
        newBST.newNode(18);
        newBST.newNode(3);
        newBST.newNode(10);
        newBST.newNode(6);
        newBST.newNode(22);
        newBST.newNode(14);
        newBST.newNode(1);
        newBST.newNode(9);
        newBST.newNode(11);
        newBST.newNode(12);

        // Finding elements in BST ("newBST")
        newBST.searchForNode(7);
        newBST.showBSTLeastVal(newBST.nodeRoot);
        newBST.showBSTGreatestVal(newBST.nodeRoot);
        newBST.showBSTHeight(newBST.nodeRoot);

        // Traversal of elements in BST ("newBST")
        System.out.println("The in-order traversal of this Binary Search Tree is: ");
        newBST.bstShowTraversalInOrder(newBST.nodeRoot);

        System.out.println("\nThe pre-order traversal of this Binary Search Tree is: ");
        newBST.bstShowTraversalPreOrder(newBST.nodeRoot);

        System.out.println("\nThe post-order traversal of this Binary Search Tree is: ");
        newBST.bstShowTraversalPostOrder(newBST.nodeRoot);

        System.out.println("\nThe breadth first search traversal of this Binary Search Tree is: ");
        newBST.printBreadthFirstSearch();
    }
}