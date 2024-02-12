public class MultiStackArray {
    private int size;
    private int[] stackElements;
    private int[] top;

    public MultiStackArray(int size, int numberOfStacks) {
        this.size = size;
        stackElements = new int[size * numberOfStacks];
        top = new int[numberOfStacks];
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            System.out.println("Stack " + stackNum + " is full (Overflow).");
            return; // Return without pushing the value
        }
        int index = stackNum * size + top[stackNum];
        top[stackNum]++;
        stackElements[index] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("Stack " + stackNum + " is empty.");
            return -1;
        }
        int index = stackNum * size + top[stackNum] - 1;
        top[stackNum]--;
        return stackElements[index];
    }

    public void display(int stackNum) {
        int startIndex = stackNum * size;
        int endIndex = top[stackNum] + startIndex;
    
        System.out.println("Stack " + stackNum + " elements:");
        for (int i = startIndex; i < endIndex; i++) {
            System.out.print(stackElements[i] + " ");
        }
        System.out.println();
    }

    private boolean isEmpty(int stackNum) {
        return top[stackNum] == 0;
    }

    private boolean isFull(int stackNum) {
        return top[stackNum] == size;
    }

   
}
/*The code defines  `MultiStackArray` that enables the creation of multiple stacks in a single array.
 It provides methods for pushing and popping elements from the stacks, displays stack contents, and checks for stack overflow.
  The `main` method demonstrates how to use the class by manually pushing elements into the stacks and displaying them, one stack at a time, while checking for overflow. */
