public class SortedPriorityQueue {
    private int[] queue;
    private int size;
    private int capacity;

    public SortedPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.size = 0;
    }

    public void insert(int value) {
        if (isFull()) {
            System.out.println("This Queue is full.");
            return;
        }

        int i;
        if (isEmpty()) {
            queue[0] = value;
        } else {
            for (i = size - 1; i >= 0; i--) {
                if (value > queue[i]) {
                    queue[i + 1] = queue[i];
                } else {
                    break;
                }
            }
            queue[i + 1] = value;
        }

        size++;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty.");
            return -1; // Indicates an empty queue
        }

        int removed = queue[--size];
        queue[size] = 0; // Clear the last element
        return removed;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty.");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

   
}
/*
The code defines a SortedPriorityQueue class that represents a priority queue with a sorted order. 
It uses an array to store elements and maintains a capacity and size.
 The insert method adds elements to the queue in descending order based on their value. 
 The remove method removes the highest-priority element.
  The display method prints the elements in the queue. 
  It handles full and empty conditions and uses sentinel values (-1 or 0) to indicate errors and empty states. */