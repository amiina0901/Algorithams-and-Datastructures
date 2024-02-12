/*This Java code defines a class AminaMujezinovicHeap that checks if a given array represents a max heap. 
The hasNoEmptyNodes method checks if there are any empty nodes in the array, and the satisfiesMaxHeapProperty 
method checks if the array satisfies the max heap property. The checkHeap method checks if the binary tree represented 
by the array is a heap, and the main method tests the checkHeap function. The code uses recursion to check if each node in
 the tree satisfies the max heap property. If the tree has no empty nodes and satisfies the max heap property, the code returns 
 "Given binary tree is a heap", otherwise it returns "Given binary tree is not a heap". 
 */

public class AminaMujezinovicHeap {
    // The value of an empty node is set to Integer.MIN_VALUE
    private static final int EMPTY_NODE = Integer.MIN_VALUE;
  
    // Checks if there are any empty nodes in the array
    private static boolean hasNoEmptyNodes(int[] array, int size) {
      // Iterates over the array and checks if any of the elements are equal to EMPTY_NODE
      for (int i = 0; i < size; i++) {
        if (array[i] == EMPTY_NODE)
          return false; // If an empty node is found, returns false
      }
      return true; // If no empty nodes are found, returns true
    }
  
    // Checks if the array satisfies the max heap property
    private static boolean satisfiesMaxHeapProperty(int[] array, int currentIndex, int size) {
      // If the current index is greater than or equal to the size of the array, returns true
      if (currentIndex >= size)
        return true;
  
      // Calculates the indices of the left and right children of the current node
      int leftChildIndex = 2 * currentIndex + 1;
      int rightChildIndex = 2 * currentIndex + 2;
  
      // If both children are out of bounds, returns true
      if (leftChildIndex >= size && rightChildIndex >= size)
        return true;
  
      // If the right child is out of bounds, checks if the current node is greater than or equal to its left child
      // and recursively checks if the left child satisfies the max heap property
      else if (rightChildIndex >= size)
        return array[currentIndex] >= array[leftChildIndex] && satisfiesMaxHeapProperty(array, leftChildIndex, size);
  
      // If the left child is out of bounds, checks if the current node is greater than or equal to its right child
      // and recursively checks if the right child satisfies the max heap property
      else if (leftChildIndex >= size)
        return array[currentIndex] >= array[rightChildIndex] && satisfiesMaxHeapProperty(array, rightChildIndex, size);
  
      // If neither child is out of bounds, checks if the current node is greater than or equal to both of its children
      // and recursively checks if both children satisfy the max heap property
      else
        return (
          (array[currentIndex] >= array[leftChildIndex] && satisfiesMaxHeapProperty(array, leftChildIndex, size)) &&
          (array[currentIndex] >= array[rightChildIndex] && satisfiesMaxHeapProperty(array, rightChildIndex, size))
        );
    }
  
    // Checks if the binary tree represented by the array is a heap
    private static String checkHeap(int[] array, int size) {
      // Checks if there are no empty nodes in the array and if the array satisfies the max heap property
      if (hasNoEmptyNodes(array, size) && satisfiesMaxHeapProperty(array, 0, size)) {
        return "Given binary tree is a heap";
      } else {
        return "Given binary tree is not a heap";
      }
    }
  
    // Main method to test the checkHeap function
    public static void main(String[] args) {
      int[] binaryTree = {97, 46, 37, 12, 3, 7, 31, 6, 19}; // true
  
      System.out.println(checkHeap(binaryTree, binaryTree.length)); // Prints whether the binary tree is a heap or not
    }
  }