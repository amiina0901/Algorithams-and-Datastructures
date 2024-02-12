package zadaca2;
import java.util.Arrays;
/*In the main function, i have created an array of characters 
containing the characters 'z', 'v', 'a', 's', 'g', 'd', '<', 'y', and 'h'. 
I have then printed the original array to the console. */
public class MainQuick {
    public static void main(String[] args) {
        char[] characters = {'z', 'v', 'a', 's', 'g', 'd', '<', 'y', 'h'};
        
        System.out.println("Original array: " + Arrays.toString(characters));
        
        AminaMujezinovicQuickSort.sort(characters);
        /* I have called the sort function from the QuickSort class to sort the array. 
        The sort function internally calls the quickSort function,
         which performs the quick sort and partitions the array. */
        System.out.println("Sorted array: " + Arrays.toString(characters));
    }/* print the sorted array to the console. 
    The output of the program will display the original array and the sorted array. */
}
