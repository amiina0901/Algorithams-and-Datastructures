package zadaca2;

/*The QuickSort algorithm works by selecting a pivot element from the array and
 partitioning the other elements into two sub-arrays, according to whether they are
  less than or greater than the pivot. The pivot is then placed into its final sorted position.
   This process is repeated recursively for each sub-array, until the array is fully sorted. */
class AminaMujezinovicQuickSort {
 // Function declaration to sort the input array
    public static void sort(char[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
// Function declaration to perform the quick sort
    private static void quickSort(char[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
/*The partition function in the code serves to select a pivot and rearrange the array.
 The pivot is selected as the middle element of the array.
  The elements less than the pivot are moved to the left side of the array,
   and the elements greater than the pivot are moved to the right side of the array. */
    private static int partition(char[] arr, int low, int high) {
        int pivotIndex = findPivot(arr, low, high);
        char pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static int findPivot (char[] array, int start, int end) {
        int n = end - start + 1; // number of elements in current partition
        int sum = 0;
    
        // sum ASCII values within the array
        for (int i = start; i <= end; i++) {
          sum += (int) array[i];
        }

        int avg = sum / n;
    
        return avg % n + start;
        
    }
/*The swap function in the code serves to swap the positions of two elements in the array.
 This is done by using a temporary variable to store the value of one element, 
 then assigning the value of the other element to the first element, 
 and finally assigning the value stored in the temporary variable to the second element. */
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
    
