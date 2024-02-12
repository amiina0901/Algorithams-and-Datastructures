
public class LinkModifier {
    private Node topNode;

    public LinkModifier() {
        this.topNode = null;
    }

    // Insert at the beginning of the linked list
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = topNode;
        topNode = newNode;
    }

    // Find a node with a given data value
    public Node find(int data) {
        Node current = topNode;
        while (current != null && current.data != data) {
            current = current.next;
        }
        return current;
    }

    // Delete a node with a given data value
    public Node delete(int data) {
        Node current = topNode;
        Node previous = null;

        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return null; // Node with data not found
        }

        if (previous == null) {
            topNode = current.next; // Node to be deleted is the topNode
        } else {
            previous.next = current.next;
        }

        return current;
    }

    // Display the elements in the linked list
    public void displayList() {
        Node current = topNode;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to count the number of duplicate values in the list
    public int countDuplicates() {
        int count = 0;
        Node current = topNode;

        while (current != null) {
            Node compare = current.next;

            while (compare != null) {
                if (current.data == compare.data) {
                    count++;
                    break;
                }
                compare = compare.next;
            }
            current = current.next;
        }

        return count;
    }

    // Method to remove duplicate values from the list
    public void removeDuplicates() {
        Node current = topNode;

        while (current != null) {
            Node compare = current;

            while (compare.next != null) {
                if (current.data == compare.next.data) {
                    compare.next = compare.next.next;
                } else {
                    compare = compare.next;
                }
            }
            current = current.next;
        }
    }

    // Method to swap any two nodes from the list
    public void swap(int data1, int data2) {
        if (data1 == data2) {
            System.out.println("Cannot swap the same nodes.");
            return;
        }

        Node prev1 = null, curr1 = topNode;
        Node prev2 = null, curr2 = topNode;

        while (curr1 != null && curr1.data != data1) {
            prev1 = curr1;
            curr1 = curr1.next;
        }

        while (curr2 != null && curr2.data != data2) {
            prev2 = curr2;
            curr2 = curr2.next;
        }

        if (curr1 == null || curr2 == null) {
            System.out.println("One or both nodes not found.");
            return;
        }

        if (prev1 != null) {
            prev1.next = curr2;
        } else {
            topNode = curr2;
        }

        if (prev2 != null) {
            prev2.next = curr1;
        } else {
            topNode = curr1;
        }

        Node temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;

        System.out.println("Swapped nodes with data " + data1 + " and " + data2);
    }

    // Method to sort the linked list
    public void sort() {
        boolean swapped;
        Node last = null;

        do {
            swapped = false;
            Node current = this.topNode;

            while (current != last && current.next != null) {
                if (current.data > current.next.data) {
                    // Swap values
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                // Move to the next node
                current = current.next;
            }
            last = current;
        } while (swapped);
    }
}

