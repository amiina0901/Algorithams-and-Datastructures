public class StackAssignDemo {
    public static void main(String[] args) {
        StackAssign stackAssign = new StackAssign(20);  // Create an instance of the StackAssign class

        // Scenario 1: Push elements into the stacks
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 5; j++) {
                stackAssign.push(i, j);  // Push elements into the stacks
            }
        }

        System.out.println("Scenario 1: Elements pushed into stacks:");
        stackAssign.display();  // Display the elements in the stacks

        // Scenario 2: Attempt to push more elements to demonstrate overflow
        stackAssign.push(0, 6); // Overflow in Stack 0
        stackAssign.push(1, 6); // Overflow in Stack 1

        System.out.println("Scenario 2: Attempting to push more elements (Overflow):");
        stackAssign.display();  // Display the elements after the overflow
    }
}