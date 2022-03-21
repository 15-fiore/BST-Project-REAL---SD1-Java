package base;

/** The Node class is responsible for including and initializing all the constructors for the nodes that interact with
 * the Binary Search Tree (BST).
 *
 */
public class Node {
    /** value -- integer value held within the node
     * nodeLeft -- the left child of the node
     * nodeRight -- the right child of the node
     * nodeRoot -- the root node of the node
     *
     */
    int value;
    Node nodeLeft;
    Node nodeRight;
    Node nodeRoot;

    /** Node method - Initializes all constructors for the node class
     *
     * @param value The value implemented by the user
     */
    public Node(int value) {
        this.value = value;
    }
}