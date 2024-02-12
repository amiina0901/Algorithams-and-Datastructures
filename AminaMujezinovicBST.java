import java.util.ArrayList;
import java.util.List;

// AminaMujezinovicBST class represents a Binary Search Tree with unique functionalities
public class AminaMujezinovicBST {
    // Node class representing each node in the BST
    private TreeNode root;

    // Constructor initializes an empty BST
    public AminaMujezinovicBST() {
        this.root = null;
    }

    // Add a new node with a given value to the BST
    public void addNode(int value) {
        this.root = insert(this.root, value);
    }

    // Recursive helper method for adding a node to the BST
    private TreeNode insert(TreeNode current, int value) {
        if (current == null) {
            // If the current node is null, create a new node with the given value
            return new TreeNode(value);
        }

        // Decide whether to go left or right based on the value
        if (value < current.data) {
            current.left = insert(current.left, value);
        } else if (value > current.data) {
            current.right = insert(current.right, value);
        }

        return current;
    }

    // Find a node with a specific value in the BST
    public TreeNode findNode(int targetValue) {
        return findNodeRecursive(this.root, targetValue);
    }

    // Recursive helper method for finding a node with a specific value
    private TreeNode findNodeRecursive(TreeNode current, int targetValue) {
        if (current == null) {
            // If the current node is null, the value is not found
            return null;
        }

        // Decide whether to search in the left or right subtree
        if (targetValue < current.data) {
            return findNodeRecursive(current.left, targetValue);
        } else if (targetValue > current.data) {
            return findNodeRecursive(current.right, targetValue);
        } else {
            // If the target value is found, return the current node
            return current;
        }
    }

    // Display all paths from the root to leaf nodes for a given target value
    public void displayPaths(int targetValue) {
        TreeNode targetNode = findNode(targetValue);

        if (targetNode == null) {
            // If the target node is not found, print a message
            System.out.println("Value " + targetValue + " not found!");
            return;
        }

        System.out.println("Target: " + targetValue);
        System.out.println("Paths:");
        displayPathsRecursive(targetNode);
    }


    private void displayPathsRecursive(TreeNode root) {
        // leaf node reached, print the path
        if (root.left == null && root.right == null) {
          printPath(root.data);
        }
        // not a leaf node, go left
        if (root.left != null) {
          displayPathsRecursive(root.left);
        }
        // not a leaf node, go right
        if (root.right != null) {
         displayPathsRecursive(root.right);
        }
      }
   

  // Prints the path from the root to a node with a specific value.
 
public void printPath(int targetValue) {
    printPathRec(this.root, targetValue);
}

// Recursive helper method to print the path from the root to a node with a specific value.
 
private void printPathRec(TreeNode root, int targetValue) {
    if (root == null) {
        // Base case: The current node is null (just to be safe)
        return;
    } else if (targetValue > root.data) {
        // Go right and print the current node's value
        System.out.print(root.data + " - ");
        printPathRec(root.right, targetValue);
    } else if (targetValue < root.data) {
        // Go left and print the current node's value
        System.out.print(root.data + " - ");
        printPathRec(root.left, targetValue);
    } else {
        // Value found, recursion ends, print the current node's value
        System.out.println(root.data);
    }
}


    // Count the total number of nodes in the BST
    public int countNodes() {
        return countNodesRecursive(this.root);
    }

    // Recursive helper method for counting nodes
    private int countNodesRecursive(TreeNode current) {
        if (current == null) {
            // If the current node is null, return 0
            return 0;
        }

        // Return the count of nodes in the left and right subtrees plus 1 (for the current node)
        return 1 + countNodesRecursive(current.left) + countNodesRecursive(current.right);
    }

    // Find the successor (next greater element) of a node with a specific value
    public void findSuccessor(int targetValue) {
        TreeNode targetNode = findNode(targetValue);
        if (targetNode == null) {
            // If the target node is not found, print a message
            System.out.println("Value " + targetValue + " not found!");
            return;
        }

        if (targetNode.right != null) {
            // If the target node has a right subtree, find the smallest value in it
            System.out.println(findMin(targetNode.right).data);
            return;
        }

        TreeNode successor = findSuccessorRecursive(this.root, targetNode, null);

        if (successor == null) {
            // If no successor is found, print a message
            System.out.println("No greater element than target value " + targetValue);
        } else {
            // Print the successor value
            System.out.println(successor.data + " is the next greater element of target value " + targetValue);
        }
    }

    // Recursive helper method for finding the successor
    private TreeNode findSuccessorRecursive(TreeNode root, TreeNode target, TreeNode successor) {
        if (root == null) {
            // If the current node is null, return the successor
            return successor;
        }

        // Traverse from root to target node to find the successor
        if (root.data > target.data) {
            return findSuccessorRecursive(root.left, target, root);
        } else if (root.data < target.data) {
            return findSuccessorRecursive(root.right, target, successor);
        } else {
            return successor;
        }
    }

    // Find the smallest value in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            // Keep traversing left until the smallest value is found
            node = node.left;
        }
        return node;
    }

    // Perform in-order traversal of the BST
    public void inOrderTraversal() {
        System.out.print("Inorder Traversal: ");
        inOrderTraversalRecursive(this.root);
        System.out.println();
    }

    // Recursive helper method for in-order traversal
    private void inOrderTraversalRecursive(TreeNode current) {
        if (current == null) {
            // If the current node is null, return
            return;
        }

        // Traverse left, visit current node, then traverse right
        inOrderTraversalRecursive(current.left);
        System.out.print(current.data + " ");
        inOrderTraversalRecursive(current.right);
    }

    // Perform pre-order traversal of the BST
    public void preOrderTraversal() {
        System.out.print("Preorder Traversal: ");
        preOrderTraversalRecursive(this.root);
        System.out.println();
    }

    // Recursive helper method for pre-order traversal
    private void preOrderTraversalRecursive(TreeNode current) {
        if (current == null) {
            // If the current node is null, return
            return;
        }

        // Visit current node, then traverse left and right
        System.out.print(current.data + " ");
        preOrderTraversalRecursive(current.left);
        preOrderTraversalRecursive(current.right);
    }

    // Perform post-order traversal of the BST
    public void postOrderTraversal() {
        System.out.print("Postorder Traversal: ");
        postOrderTraversalRecursive(this.root);
        System.out.println();
    }

    // Recursive helper method for post-order traversal
    private void postOrderTraversalRecursive(TreeNode current) {
        if (current == null) {
            // If the current node is null, return
            return;
        }

        // Traverse left and right, then visit current node
        postOrderTraversalRecursive(current.left);
        postOrderTraversalRecursive(current.right);
        System.out.print(current.data + " ");
    }

    // Main method for testing the BST functionalities
    public static void main(String[] args) {
        AminaMujezinovicBST uniqueTree = new AminaMujezinovicBST();
        uniqueTree.addNode(8);
        uniqueTree.addNode(3);
        uniqueTree.addNode(9);
        uniqueTree.addNode(12);
        uniqueTree.addNode(14);
        uniqueTree.addNode(7);
        uniqueTree.addNode(11);

        // Part a
        uniqueTree.displayPaths(11);
        // Part b
        uniqueTree.findSuccessor(11);
        // Part c
        System.out.println();
        uniqueTree.inOrderTraversal();
        uniqueTree.preOrderTraversal();
        uniqueTree.postOrderTraversal();
        System.out.println();
        // Part d
        System.out.println("Number of nodes: " + uniqueTree.countNodes());
    }

    // TreeNode class representing each node in the BST
    private static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        // Constructor to create a new node with a given value
        public TreeNode(int data) {
            this.data = data;
        }
    }
}
