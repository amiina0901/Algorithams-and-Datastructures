public class SortedPriorityQueueDemo {
    public static void main(String[] args) {
        int capacity = 5; // Define the capacity of the Priority Queue
        SortedPriorityQueue priorityQueue = new SortedPriorityQueue(capacity);

        // Insert elements with descending priority
        priorityQueue.insert(7);
        priorityQueue.insert(9);
        priorityQueue.insert(10);
        priorityQueue.insert(8);
        priorityQueue.insert(6);

        System.out.print("Inserted elements: ");
        priorityQueue.display();
       
    }
}
