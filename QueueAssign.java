public class QueueAssign {
    private int[] array;
    private int size;
    private int capacity;

    public QueueAssign(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public void insert(int value) {
        if (isFull()) {
            System.out.println("Priority Queue is full. Cannot insert " + value);
            return;
        }

        int index = size - 1;
        while (index >= 0 && array[index] < value) {
            array[index + 1] = array[index];
            index--;
        }
        array[index + 1] = value;
        size++;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty.");
            return -1; // Return a default value for an empty queue
        }

        int value = array[size - 1];
        size--;
        return value;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) {
                System.out.print("-");
            }
        }
        System.out.println();
    }
    
    
}