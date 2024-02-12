public class StackAssign {
    private int[] array;       // The single array to hold elements for all four stacks
    private int[] tops;        // To keep track of the top element in each stack
    private int stackSize;     // The number of stacks

    public StackAssign(int capacity) {
        this.stackSize = 4;    // We have four stacks
        this.array = new int[capacity];  // Create the array with the given capacity
        this.tops = new int[stackSize];  // Initialize top pointers for each stack
        
        // Initialize top pointers for each stack
        for (int i = 0; i < stackSize; i++) {
            tops[i] = i * (capacity / stackSize) - 1;  // Distribute top pointers evenly
        }
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            System.out.println("Stack " + stackNum + " is full (Overflow).");
        } else {
            tops[stackNum]++;     // Move the top pointer up
            array[tops[stackNum]] = value;  // Place the value at the new top position
        }
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("Stack " + stackNum + " is empty (Underflow).");
            return -1; // Return a default value for underflow
        } else {
            int value = array[tops[stackNum]];  // Get the value at the top
            tops[stackNum]--;   // Move the top pointer down
            return value;
        }
    }

    public boolean isFull(int stackNum) {
        return tops[stackNum] == (stackNum + 1) * (array.length / stackSize) - 1;
        // Check if the top pointer reached the end of the stack
    }

    public boolean isEmpty(int stackNum) {
        return tops[stackNum] == stackNum * (array.length / stackSize) - 1;
        // Check if the top pointer is at the bottom of the stack
    }

    public void display() {
        for (int i = 0; i < stackSize; i++) {
            System.out.print("Stack " + i + ": ");
            for (int j = i * (array.length / stackSize); j <= tops[i]; j++) {
                System.out.print(array[j] + " ");  // Print elements in the stack
            }
            System.out.println();  // Move to the next line for the next stack
        }
    }
}