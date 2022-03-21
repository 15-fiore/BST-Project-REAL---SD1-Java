package base;

/** The BST class is responsible for including all the methods that interact with the Binary Search Tree (BST).
 * These methods - the ones that are "public", can then be called in the main Class, which will execute and show
 * the user the attributes of the BST (finding node, smallest/largest node, deleting node, tree traversals, etc.)
 */
public class BST extends Node {
    /**
     * Node method - Initializes all constructors for the node class
     *
     * @param value The value implemented by the user
     */
    public BST(int value) {
        super(value);
    }

    /**
     * Public Method to add values into the BST. The computation of this method takes place in the "addNode" method
     * below.
     *
     * @param value The value implemented by the user in the parameter of the method
     */
    public void newNode(int value) {
        nodeRoot = addNode(nodeRoot, value);
    }

    /**
     * Private method to compute the addition of a value into the BST.
     *
     * In this method, a check using an "if" statement is performed to see if a  root node - "nodeRoot" - exists in the
     * BST. If the root node does not exist yet, then the implemented value becomes the root node of the BST. Otherwise,
     * the method proceeds to the "else" statement to determine the placement of the value.
     *
     * Within the "else" statement, an if-else statement is used to see where the new value will be placed. The
     * statement begins with the root node. If the value is less than OR equal to the root node, then the left child of
     * the root node will be checked. If the value is greater than the root node, then the right child of the root node
     * will be checked.
     *
     * The next call will be recursive, now using the left/right child of the root node as the "root node",
     * brought on by the initial check above. The use of recursion will check to see if the child of the previous node
     * exists. If it does, then compare the value to the node's children. If it does not, then create a new instance of
     * the node class, effectively adding a node to the BST.
     *
     * @param nodeRoot The root node of the created BST
     * @param value The value implemented by the user in the parameter of the method
     * @return Return the current "nodeRoot" value to recurse through the BST.
     */
    private Node addNode(Node nodeRoot, int value) {
        // Primary "if" statement - used to initialize tree if there are no values
        if (nodeRoot == null) {
            // Creation of new "Node" instance
            nodeRoot = new Node(value);
            System.out.println("The value '" + value + "' has been added to the Binary Search Tree.");

        }

        // Primary "else" statement - used to add values to the tree once initialized
        else {
            // Secondary "if" statement - Add values to the left of the "nodeRoot" value if <=
            if (value <= nodeRoot.value) {
                nodeRoot.nodeLeft = addNode(nodeRoot.nodeLeft, value);

            }

            // Secondary "else" statement - Add values to the right of the "nodeRoot" value if >
            else {
                nodeRoot.nodeRight = addNode(nodeRoot.nodeRight, value);

            }
        }

        return nodeRoot;
    }

    /**
     * Public Method to add values into the BST. The computation of this method takes place in the "addNode" method
     * below.
     * @param value The value implemented by the user in the parameter of the method
     */
    public void searchForNode(int value) {
        findNode(nodeRoot, value);
    }

    /**
     * Private method to compute the search to find a Node instance within BST.
     *
     * In this method, a check using an "if" statement is performed to see if a  root node - "nodeRoot" - exists in the
     * BST. If the root node does not exist yet, then the implemented value becomes the root node of the BST. Otherwise,
     * the method proceeds to the "else" statement to determine the placement of the value in an other node.
     *
     * Within the "else" statement, an "if-elif-else" statement is used to check the value from the parameter to the
     * root node. If the value is less than the root node, then check the left child of the root node. If the the value
     * is greater than the root node, then check the right child of the root node. If the value is equal to the root
     * node, then print to the user that the value does exist in the BST.
     *
     * In the event that the value is not that of the root node, the next call will be recursive, now using the
     * left/right child of the root node as the "root node", brought on by the initial check above. The use of recursion
     * will check to see if the value given from the parameter is the left/right child, repeating the process above.
     *
     * If, after recursively traveling through the tree to find a node with the value from the parameter, no such node
     * can be found, then print to the user that the value does NOT exist in this BST.
     *  @param nodeRoot The root node of the BST. See the JavaDoc above "addNode" to understand how the
     *                 root node is created.
     * @param value The value implemented by the user in the parameter of the method
     */
    private static void findNode(Node nodeRoot, int value) {
        // If NodeRoot does not exist OR the value of NodeRoot = the requested value, then return such value
        if (nodeRoot == null) {
            // Print statement to user showing the value has not been found within the BST
            System.out.println("Sorry, but the value '" + value + "' does not exist in this Binary Search Tree.");
        }

        else {
            if (nodeRoot.value == value) {
                // Print statement to user showing the value has been found within the BST
                System.out.println("Yes, the value " + value + " exists within this Binary Search Tree.");
            }

            // If NodeRoot does not = the requested value, check the left and right nodes - recursive call
            else if (value <= nodeRoot.value) {
                findNode(nodeRoot.nodeLeft, value);
            }

            else {
                findNode(nodeRoot.nodeRight, value);
            }
        }
    }

    /** Public method to show the height of the BST. The computation of this method takes place in the "bstHeight"
     * method.
     * @param nodeRoot The root node of the created BST.
     */
    public void showBSTHeight(Node nodeRoot) {
        System.out.println("The height of this Binary Search Tree is " + bstHeight(nodeRoot) + ".");
    }

    /** Private method to compute the height of the BST.
     * In this method, a check using an "if" statement is used to determine if the BST has a height. This is done by
     * checking if the root node exists. If the root node does not exist - equals "null" - then there is no active nodes
     * in the BST. Therefore, the BST would have a height of 0, and the method will return this value to the user.
     *
     * If the root node does exist, then the method will progress to the following "else" statement. The "else"
     * statement, will initialize two variables - bstHeightLeftVal and bstHeightRightVal - to calculate the height of
     * all children in the BST. This is done using a recursive call, which will move through both sides of
     * the BST.
     *
     * The recursion will move top-to-bottom to each node, comparing each node's left and right children. If
     * the left child of a node has a height greater than the right child, then the variable holding the value of the
     * height of the left children will increment by 1. If not, then the variable holding the value of the height of
     * the right children will increment by 1. This process is repeated back towards the top of the tree, where the
     * children of the root node will have the heights of their side of the BST. Whichever side is "taller", add 1 to
     * that value - the root node - to calculate the height of the BST.
     *
     * @param nodeRoot The root node of the created BST
     * @return Return the values of the variables holding the height of each node in the BST
     */
    private int bstHeight(Node nodeRoot) {
        // If the root node does not exist, return a value of 0 - no height in the Binary Search Tree.
        if (nodeRoot == null) {
            return 0;
        }

        // If the root node does exist, check the height of the node's corresponding children - recursive call
        else {

            // Check the height of the left child of parent node - recursive call.
            int bstHeightLeftVal = bstHeight(nodeRoot.nodeLeft);
            // Check the height of the right child of parent node - recursive call
            int bstHeightRightVal = bstHeight(nodeRoot.nodeRight);

            // Check which calculated height is larger - use the largest one.
            if (bstHeightLeftVal > bstHeightRightVal) {
                return (bstHeightLeftVal + 1);
            }

            else {
                return (bstHeightRightVal + 1);
            }
        }
    }

    /** Public method to show the node with the least integer value in the BST. The computation of this method takes
     * place in the "bstLeastVal" method.
     * @param nodeRoot The root node of the created BST
     */
    public void showBSTLeastVal(Node nodeRoot) {
        bstLeastVal(nodeRoot);
    }

    /** Private method to compute the least integer value in the BST.
     * The least value in the BST would be located in the bottom-leftmost node of the BST. To access this node, an
     * if-else" statement has been constructed to find this node.
     *
     * The "if" statement checks to see if the root node has a left child. If the root node does not have a left child,
     * then this node must be the bottom-leftmost node of the BST, therefore the node with the least value. If the root
     * node does have a left child, then the node does not have the least value, and further nodes must be checked.
     *
     * The "else" statement recursively calls the method with the root node's left child, checking to see if the child
     * of the root node (or the left child of the root node, progressing to the left child of that node, etc.) is the
     * bottom-leftmost node.
     *
     * In the event that there is no root node, then the BST does not have a least value. The method will return the
     * value of "0" if this is the case.
     * @param nodeRoot The root node of the created BST
     * @return Return 0 if there is no root node to the BST
     */
    private int bstLeastVal(Node nodeRoot) {

        // If there is no left node for the current root node, then the least value is found.
        // Print statement to show user what the least-valued node is.
        if (nodeRoot.nodeLeft == null) {
            System.out.println("The value '" + nodeRoot.value + "' is the lowest value within this Binary Search " +
                    "Tree.");
        }

        // If there is a left node for the current value - toggle to the next left node - recursive call?
        else {
            bstLeastVal(nodeRoot.nodeLeft);
        }
        return 0;
    }

    /** Public method to show the node with the greatest integer value in the BST. The computation of this method takes
     * place in the "bstGreatestVal" method.
     * @param nodeRoot The root node of the created BST
     */
    public void showBSTGreatestVal(Node nodeRoot) {
        bstGreatestVal(nodeRoot);
    }

    /** Private method to compute the greatest integer value in the BST.
     * The greatest value in the BST would be located in the bottom-rightmost node of the BST. To access this node, an
     * if-else" statement has been constructed to find this node.
     *
     * The "if" statement checks to see if the root node has a right child. If the root node does not have a right child,
     * then this node must be the bottom-rightmost node of the BST, therefore the node with the greatest value. If the
     * root node does have a right child, then the node does not have the greatest value, and further nodes must be
     * checked.
     *
     * The "else" statement recursively calls the method with the root node's right child, checking to see if the child
     * of the root node (or the right child of the root node, progressing to the right child of that node, etc.) is the
     * bottom-rightmost node.
     *
     * In the event that there is no root node, then the BST does not have a greatest value. The method will return the
     * value of "0" if this is the case.
     * @param nodeRoot The root node of the created BST
     */
    private void bstGreatestVal(Node nodeRoot) {
        // If there is no right node for the current value - "currentValL.nodeRight" - then the greatest value is found.
        // Print statement to show user what the greatest-valued node is.
        if (nodeRoot.nodeRight == null) {
            System.out.println("The value '" + nodeRoot.value + "' is the greatest value within this Binary Search " +
                    "Tree.");
        }

        // If there is a right node for the current value - toggle to the next right node - recursive call?
        else {
            bstGreatestVal(nodeRoot.nodeRight);
        }
    }

    /** EMPTY: Method to find "n"th greatest value of a Node within BST
     *
     * @param valN ignore
     */
    public void bstGreatestToNVal(int valN) {
        throw new UnsupportedOperationException();
    }

    /** NOT WORKING: Public Method to show the deletion of a node/value from the BST. The computation for this method can be seen in
     * the "removeNode" method.
     * @param value The value implemented by the user
     */
    public void deleteNode(int value) {
        nodeRoot = removeNode(nodeRoot, value);
    }

    /** NOT WORKING: Private Method to compute the deletion of a node/value from the BST.
     *
     * @param nodeRoot The root node of the created BST
     * @param value The value implemented by the user
     * @return Return the child of the current root node, or nothing if no root node exists
     */
    private Node removeNode(Node nodeRoot, int value) {
        // Check to see if the Binary Search Tree is empty.
        if (nodeRoot == null)
            return null;

        // If the intended value is not the checked node, cycle to the left child
        if (value < nodeRoot.value) {
            nodeRoot.nodeLeft = removeNode(nodeRoot.nodeLeft, value);
        }

        // If the intended value is not the checked node, cycle to the right child
        else if (value > nodeRoot.nodeLeft.value) {
            nodeRoot.nodeRight = removeNode(nodeRoot.nodeRight, value);

        }

        // If the intended value is equal to the checked node, proceed with deleting the node
        else {
            // Deletion of node with only 0-1 child
            if (nodeRoot.nodeLeft == null)
                return nodeRoot.nodeRight;
            else if (nodeRoot.nodeRight == null)
                return nodeRoot.nodeLeft;

            // Deletion of node with 2 children node with two children --> using inorder succession
            nodeRoot.value = bstLeastVal(nodeRoot.nodeRight);

            // Recurse the method to the right child so the inorder successor can be deleted
            nodeRoot.nodeRight = removeNode(nodeRoot.nodeRight, nodeRoot.value);
        }

        return nodeRoot;
    }

    /** Public method to show the in-order traversal of the BST. The computation for this method can be seen in the
     * "bstShowTraverseInOrder" method.
     * @param nodeRoot The root node of the created BST
     */
    public void bstShowTraversalInOrder(Node nodeRoot) {
        bstTraverseInOrder(nodeRoot);
    }

    /** Private method to traverse BST in-order.
     *
     * This method uses recursion to pass through the nodes in the BST. The initial "if" statement checks to see if the
     * searched node exists within the BST. If it exists (not null), then traversal can continue.
     *
     * First, travel to the left child of the root node using the first recursive call
     * (since in-order traversal is presented in left-root-right). This will be recursively followed to the
     * bottom-leftmost node, where the traversal will start. Once the bottom-leftmost node is reached a further left
     * child will not exist - equal null, and so the first recursion cannot continue. Because of this, the
     * bottom-leftmost node - the parent of the null left child - will be returned and stored into the method. Since
     * recursion can no longer continue left (the recursion has already happened), the value of said node will be
     * printed.
     *
     * Then, the right child of the printed node will be reached using the second recursive statement, following the
     * same framework as above.
     *
     * This process will continue up through the left side of the BST, before repeating itself down the right side of
     * the BST. After returning up from the right side of the tree, all values in the BST shall be printed.
     * @param nodeRoot The root node of the created BST
     */
    private void bstTraverseInOrder (Node nodeRoot) {
        // Recursive "if" statement to see if searched node exists within the BST. If the searched node exists,
        // traverse the BST and print values.
        if (nodeRoot != null) {
            // If the searched node has a left child, traverse to it. Useful to find starting point of in-order
            // traversal at bottom-left-most node - recursive call.
            bstTraverseInOrder(nodeRoot.nodeLeft);

            // If the searched node (a) cannot progress to a child node - if coming from leftmost child node -,
            // (b) has already traversed the left subtree of a root node, or (c) has already traversed and printed its
            // children nodes, then print the searched node's value.
            System.out.print(nodeRoot.value + " ");

            // If the searched node has a right child, traverse to it - recursive call.
            bstTraverseInOrder(nodeRoot.nodeRight);

        }
    }

    /** Public method to show the pre-order traversal of the BST. The computation for this method can be seen in the
     * "bstTraversePreOrder" method.
     * @param nodeRoot The root node of the created BST
     */
    public void bstShowTraversalPreOrder(Node nodeRoot) {
        bstTraversePreOrder(nodeRoot);
    }

    /** Private method to traverse BST pre-order.
     *
     * This method uses recursion to pass through the nodes in the BST. The initial "if" statement checks to see if the
     * searched node exists within the BST. If it exists (not null), then traversal can continue.
     *
     * First, print the value of the node root (since in-order traversal is presented in root-left-right).
     *
     * Then, travel to the left child of the root node using the first recursive call
     * recursively followed to the bottom-leftmost node, where the traversal will start. Once the bottom-leftmost node is reached a further left
     * child will not exist - equal null, and so the first recursion cannot continue. Because of this, the
     * bottom-leftmost node - the parent of the null left child - will be returned and stored into the method. Since
     * recursion can no longer continue left (the recursion has already happened), the value of said node will be
     * printed.
     *
     * Then, travel to the right child of the returned node using the second recursive statement, following the
     * same framework as above.
     *
     * This process will return up through the left side of the BST, before repeating itself down the right side of
     * the BST. After returning up from the right side of the tree, all values in the BST shall be printed.
     * @param nodeRoot The root node of the created BST
     */
    private void bstTraversePreOrder (Node nodeRoot) {
        // Recursive "if" statement to see if searched node exists within the BST. If the searched node exists,
        // traverse the BST and print values.
        if (nodeRoot != null) {
            // Print the searched node's value and traverse the node's children.
            System.out.print(nodeRoot.value + " ");

            // If the searched node has a left child, traverse to it - recursive call.
            bstTraverseInOrder(nodeRoot.nodeLeft);

            // If the searched node has a right child, and the searched node has already traversed and printed itself
            // and it's left child, traverse to it - recursive call.
            bstTraverseInOrder(nodeRoot.nodeRight);
        }
    }

    /** Public method to show the pre-order traversal of the BST. The computation for this method can be seen in the
     * "bstTraversePostOrder" method.
     * @param nodeRoot The root node of the created BST
     */
    public void bstShowTraversalPostOrder(Node nodeRoot) {
        bstTraversePostOrder(nodeRoot);
    }

    /** Private method to traverse BST post-order.
     *
     * This method uses recursion to pass through the nodes in the BST. The initial "if" statement checks to see if the
     * searched node exists within the BST. If it exists (not null), then traversal can continue.
     *
     * First, travel to the left child of the root node using the first recursive call
     * (since in-order traversal is presented in left-root-right). This will be recursively followed to the
     * bottom-leftmost node, where the traversal will start. Once the bottom-leftmost node is reached a further left
     * child will not exist - equal null, and so the first recursion cannot continue. Because of this, the
     * bottom-leftmost node - the parent of the null left child - will be returned and stored into the method.
     *
     * Then, travel to the right child of the returned node using the second recursive call
     * recursively followed to the bottom-leftmost node, where the traversal will start. Once the bottom-leftmost node is reached a further left
     * child will not exist - equal null, and so the first recursion cannot continue. Because of this, the
     * bottom-leftmost node - the parent of the null left child - will be returned and stored into the method. Since
     * recursion can no longer continue left (the recursion has already happened), the value of said node will be
     * printed.
     *
     * Then, travel to the right child of the returned node using the second recursive statement, following the
     * same framework as above. Eventually, the right child may not be accessible - equal to null. Since
     * recursion can no longer continue right (the recursion has already happened), the value of said node will be
     * printed.
     *
     * This process will return up through the left side of the BST, before repeating itself down the right side of
     * the BST. After returning up from the right side of the tree, all values in the BST shall be printed.
     * @param nodeRoot The root node of the created BST
     */
    private void bstTraversePostOrder (Node nodeRoot) {
        // Recursive "if" statement to see if searched node exists within the BST. If the searched node exists,
        // traverse the BST and print values.
        if (nodeRoot != null) {
            // If the searched node has a left child, traverse to it. Useful to find starting point of in-order
            // traversal at bottom-left-most node - recursive call.
            bstTraverseInOrder(nodeRoot.nodeLeft);

            // If the searched node can no longer progress to a left child, then traverse to the searched node's
            // right child - recursive call.
            bstTraverseInOrder(nodeRoot.nodeRight);

            // If the searched node (a) cannot progress to a child node - if coming from leftmost child node -,
            // (b) has already traversed the left and right subtrees of the searched node, and (c) has already
            // traversed and printed its children nodes, then print the searched node's value.
            System.out.print(nodeRoot.value + " ");
        }
    }

    /** Public Method to show the breadth-first traversal of the BST. The computation for this method can be seen in
     * the "computeBreadthFirstSearch" method.
     */
    public void printBreadthFirstSearch() {
        // For loop - for each level of the BST, print the value(s) of the node(s).
        for (var i = 1; i <= bstHeight(nodeRoot); i++)
            computeBreadthFirstSearch(nodeRoot, i);
    }

    /** Private Method to breadth-first traverse the BST.
     *
     * This method uses recursion to pass through the nodes in the BST. The initial "if" statement checks to see if the
     * searched node exists within the BST. If it exists (not null), then traversal can continue.
     *
     * The method begins at the root node, which per the public method has a level of 1. At this "base" level, there is
     * /are no other nodes to worry about. By being the only node on the level, the root node's value can be printed.
     *
     * After the root node level (level 1), the public method above iterates to advance this method. In doing so, the
     * method will recursively repeat the method with the children of the root node - the level 2 nodes. In doing so,
     * the recursive calls in the "else if" statement will recursively travel until they reach a level 1 node - where
     * it/they will be printed into the order.
     *
     * For the following example BST:
     *          8
     *   3              10
     *
     *  The public method would begin at level 1, which would begin the private method at the root node, 8. Since 8 has
     *  a level of 1. It is printed. Once this occurs, level 2 is taken in with the parameters. Since the level > 1, the
     *  "else if" travels through the BST recursively to get to the second level, where based on the
     *  iteration/subtraction of the level, the desired level - the second level in this case - is level 1 is ready to
     *  be printed to the user.
     *
     *  This process will continue down the BST, beginning at each level with the leftmost nodes and progressing to the
     *  right. By the end of the method, all values in the BST should be printed.
     * @param nodeRoot The root node of the created BST
     * @param level Current level of the BST - from public breadth first search method (see above)
     */
    private void computeBreadthFirstSearch (Node nodeRoot, int level) {
        // "If" statement to check if the searched node exists.
        // If it does not, do not return anything and progress to the "else" statement to traverse the BST and
        // print values.
        if (nodeRoot == null) {
            return;
        }

        // If statement to print values of nodes within the BST. If on the level of the searched node,
        // then print the value of the root node.
        if (level == 1) {
            System.out.print(nodeRoot.value + " ");
        }

        // Recursive "else if" statement to cycle through children of a node.
        else if (level > 1) {
            //
            computeBreadthFirstSearch(nodeRoot.nodeLeft, level - 1);
            computeBreadthFirstSearch(nodeRoot.nodeRight, level - 1);
        }
    }

}