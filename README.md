# Software Development I - Creation of Binary Search Tree Using Java - BST v1.0
## Welcome To 15-fiore's First Binary Search Tree (BST)!
Benjamin Fiore (GitHub: 15-fiore) <br>
Marist College Department of Computer Science and Mathematics <br>
CMPT 220L-904 <br>
Professor Aaron Kippins (GitHub: AKippins) <br>
Due: Friday 28 May 2021

---

### Introduction: What Is A Binary Search Tree?
Before working with this project, you should have a general understanding of the concepts about a Binary Search Tree
(BST). Check out the links below to learn (or refresh) on the basic principles and concepts of the BST.
[Binary Tree vs. Binary Search Tree - GeeksForGeeks](https://www.geeksforgeeks.org/difference-between-binary-tree-and-binary-search-tree/) <br>
[Binary Search Tree - Wikipedia](https://en.wikipedia.org/wiki/Binary_search_tree) <br>
[BST: Search and Insertion - GeeksForGeeks](https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/) <br>
[BST: Deletion - GeeksForGeeks](https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/) <br>
[BST: Find Minimum/Maximum Value - GeeksForGeeks](https://www.geeksforgeeks.org/find-maximum-or-minimum-in-binary-tree/#:~:text=In%20Binary%20Search%20Tree%2C%20we,return%20maximum%20of%203%20values.) <br>
[BST: Tree Traversals](https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/) <br>
[BST: Level Order Binary Tree Traversal](https://www.geeksforgeeks.org/level-order-tree-traversal/) <br>


### Project Overview
This project repository includes a working (really, mostly-working) Binary Search Tree (BST) for exclusive use with
integer values. <br>

This project, whist long and taking for a beginner programmer like myself, showcases the ability to perform basic
functions and manipulations to a pre-initialized BST. Such functions include addition/removal, finding smallest/largest
values, value search, and basic traversals. <br>

NOTE: Please understand that all features required for this project are not fully functioning. While all requested
features are listed, any feature(s) that are not currently finished and debugged will have a letter "***N***" placed next
to them.

#### Basic Features
* Add Nodes/Values to the BST
* Search the BST to see if a value exists on an existing node
* Find the smallest/largest value/node within the BST
* Find the "nth" largest value/node within the BST - ***N***
* Find the height of the BST
* Delete a node from the BST - ***N***
* Traversals
    * In-Order
    * Pre-Order
    * Post-Order
    * Depth-First Search - ***N***
    * Breadth-First Search

### Using The BST
The current version of the BST requires the edit of the main class that holds all interactive methods within the
program. This can be found within the **main** class, which is located within the **main.java** file. <br>

#### Manipulating The BST

Within the **main.java** class you will notice different lines of code that call different methods that interact with
the BST. The *editable* methods used are as follows:

```java
var newBST = newBST(); // Creation of new Binary Search Tree (BST)
<bstname>.newNode(int value); // Add new node to BST
<bstname>.searchForNode(int value); // Searches selected BST for value
<bstname>.bstLeastVal(<bstname>.nodeRoot); // Searches for least value in the selected BST
<bstname>.bstGreatestVal(<bstname>.nodeRoot); // Searches for greatest value in the selected BST
<bstname>.newNode(int value); // Delete node from the selected BST, and reorganize remaining value(s)/node(s)
```
The *editable* methods can be added in the main class to further develop the BST, or create new BSTs.

The *non-editable* methods used are as follows:

```java
System.out.println("The height of this Binary Search Tree is " + newBST.bstHeight(newBST.nodeRoot) + ".");
// Finds the height of the selected BST
System.out.println("The in-order traversal of this Binary Search Tree is: ");
newBST.bstTraverseInOrder(newBST.nodeRoot);
// Prints the value(s)/nodes of the selected BST using in-order traversal

System.out.println("The pre-order traversal of this Binary Search Tree is: ");
newBST.bstTraversePreOrder(newBST.nodeRoot);
// Prints the value(s)/nodes of the selected BST using pre-order traversal

System.out.println("The post-order traversal of this Binary Search Tree is: ");
newBST.bstTraversePostOrder(newBST.nodeRoot);
// Prints the value(s)/nodes of the selected BST using post-order traversal

System.out.println("The breadth first search traversal of this Binary Search Tree is: ");
newBST.breadthPrintLevelOrder();
// Prints the value(s)/nodes of the selected BST using breadth-first search traversal
```
Changing and/or removing any of these *non-editable* methods may prevent access to some features of this Binary Search
Tree program. While these methods may be added for additional BSTs, they should exist in every initialized instance of
a BST.

#### Executing The BST
Once all editable changes are made, execute the **main.java** class in console.

---

### License
[MIT](https://choosealicense.com/licenses/mit/)