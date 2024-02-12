public class MultiStackArrayDemo {
    public static void main(String[] args) {
        int size = 5; // Set the size for each individual stack
        int numberOfStacks = 4; // Define the number of stacks
        MultiStackArray multiStack = new MultiStackArray(size, numberOfStacks);

        // Push elements onto the stacks
        multiStack.push(0, 5);
        multiStack.push(0, 8);
        multiStack.push(1, 2);
        multiStack.push(1, 7);
        multiStack.push(1, 8);
        multiStack.push(2, 9);
        multiStack.push(2, 11);
        multiStack.push(2, 5);
        multiStack.push(2, 28);
        multiStack.push(3, 6);
        multiStack.push(3, 17);
        multiStack.push(3, 14);
        multiStack.push(3, 5);
        multiStack.push(3, 45);
        multiStack.push(3, 15);
        

        // Display the contents of the entire array steck by steck
        for (int i = 0; i < numberOfStacks; i++) {
            multiStack.display(i);
        }
}
}
