public class AminaMujezinovicHash {

    // Prints the contents of an integer array to the console
    private static void printArray(int[] array) {
       System.out.print("Original Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Prints the contents of a subarray of an integer array to the console
    private static void printSubarray(int[] array, int subarrayStart, int subarrayEnd) {
        System.out.print("Largest Consecutive Subarray: ");
        for (int i = subarrayStart; i < subarrayEnd; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Finds the largest consecutive subarray in an integer array
    private static void findLargestConsecutiveSubarray(int[] array) {
        int leftPointer = 0; // Pointer to the start of the current subarray
        int rightPointer = 0; // Pointer to the end of the current subarray
        int largestSubarrayStart = 0; // Pointer to the start of the largest subarray found so far
        int largestSubarrayEnd = 0; // Pointer to the end of the largest subarray found so far
        HashTable visited = new HashTable(array.length); // Hash table to keep track of visited elements
/*The findLargestConsecutiveSubarray method finds the largest consecutive subarray in an integer array. 
It uses a hash table to keep track of visited elements. The method initializes two pointers, leftPointer and rightPointer,
 to the start of the current subarray. It also initializes two variables, largestSubarrayStart and largestSubarrayEnd,
  to the start and end of the largest subarray found so far. */
     
  
  // Iterate through the array
        while (rightPointer < array.length) {
            if (visited.hasBeenVisited(array[rightPointer])) {
                // If the current element has been visited before, check if the current subarray is larger than the largest subarray found so far
                if (rightPointer - leftPointer > largestSubarrayEnd - largestSubarrayStart) {
                    largestSubarrayStart = leftPointer;
                    largestSubarrayEnd = rightPointer;
                }
                // Move the left pointer to the next unvisited element
                leftPointer++;
                rightPointer = leftPointer;
                // Clear the visited hash table
                visited = new HashTable(array.length);
            } else {
                // If the current element has not been visited before, add it to the visited hash table
                visited. markAsVisited(array[rightPointer]);
                rightPointer++;
            }
        }

        // Check if the last subarray is the largest subarray
        if (rightPointer - leftPointer > largestSubarrayEnd - largestSubarrayStart) {
            largestSubarrayStart = leftPointer;
            largestSubarrayEnd = rightPointer;
        }

        // Print the original array and the largest consecutive subarray
        printArray(array);
        printSubarray(array, largestSubarrayStart, largestSubarrayEnd);
    }

    // Hash table implementation
    private static class HashTable {
        private static final int EMPTY_CELL = Integer.MIN_VALUE;
        private int[] hashTable;
        private int hashTableSize;
/*HashTable: This is a private static nested class that implements 
a simple hash table data structure. It uses separate chaining to handle collisions. */
    
// Constructor
        public HashTable(int size) {
            int nextPrime = getNextPrime(size);
            this.hashTableSize = nextPrime;
            this.hashTable = new int[nextPrime];
            for (int i = 0; i < nextPrime; i++) {
                hashTable[i] = EMPTY_CELL;
            }
        }

        /*getNextPrime: This function returns the next prime number greater than the input number.
         It uses a while loop to check if the input number is prime by dividing it by all numbers up to its square root.
          If the input number is prime, it returns it. Otherwise, it increments the input number by 1 and continues the loop. */
        private int getNextPrime(int num) {
            int nextPrime = num + 1;
            while (true) {
                boolean isPrime = true;
                for (int i = 2; i <= Math.sqrt(nextPrime); i++) {
                    if (nextPrime % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime)
                    return nextPrime;
                nextPrime++;
            }
        }

        /*calculateHash: This function takes an integer key as input and returns its hash code.
         It calculates the hash code by taking the key modulo the hash table size and adding the
          hash table size to ensure that the index is always positive. */
        private int calculateHash(int key) {
            return (key % this.hashTableSize + this.hashTableSize) % this.hashTableSize;
        }

       /*calculateSecondaryHash: This function takes an integer key as input and returns its secondary hash code.
        It calculates the secondary hash code by taking the negative of the key modulo a constant value. */
        private int calculateSecondaryHash(int key) {
            int c = 11;
            return c - (key % c);
        }

        /* markAsVisited: This function  markAsVisiteds a key into the hash table. It calculates the hash code and the secondary hash code for the key.
         It then enters a while loop that continues until it finds an empty cell in the hash table. Inside the loop, it calculates the 
         next index by adding the secondary hash code to the current index. If the cell at the current index is empty, it  markAsVisiteds the key
          into that cell and returns. */
        public void  markAsVisited(int key) {
            int index = calculateHash(key);
            while (hashTable[index] != EMPTY_CELL) {
                index = (index + calculateSecondaryHash(key)) % this.hashTableSize;
            }
            hashTable[index] = key;
        }

        // Checks if the input key is in the hash table
        public boolean hasBeenVisited(int key) {
            int index = calculateHash(key);
            while (hashTable[index] != EMPTY_CELL) {
                if (hashTable[index] == key)
                    return true;
                index = (index + calculateSecondaryHash(key)) % this.hashTableSize;
            }
            return false;
        }
    }

    // Main method
    public static void main(String[] args) {
        int[] array = {2, 0, 2, 1, 4, 3, 1, 0};
        findLargestConsecutiveSubarray(array);
    }
}