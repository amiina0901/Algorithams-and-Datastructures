package zadaca2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*In the Main program, i use a Scanner object to read user input. i create a List of Integers called list to store the input elements.

The Scanner reads the elements from the user and stores them in the list until it encounters the string 'n'. The 'n' is used to signal the end of input. */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// Create a Scanner object to read user input
        List<Integer> list = new ArrayList<>();// Create a List of Integers to store the input elements
        System.out.println("Enter the elements (enter 'n' to stop):");
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());// Read the elements from the user and store them in the list
        }
        scanner.next(); // consume the 'n'
        
        int[] arr = list.stream().mapToInt(i -> i).toArray();// Convert the list into an array of integers called arr
        
        AminaMujezinovicMergesort.mergeSort(arr, 0, arr.length - 1); // Call the mergeSort function on the arr array
                
        System.out.println("Sorted array (even-odd separated):");
        for (int num : arr) {
            System.out.print(num + " ");// Print the sorted array to the console
        }
    }
}