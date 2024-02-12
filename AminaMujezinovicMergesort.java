package zadaca2;

public class AminaMujezinovicMergesort {
    /* This function takes an array and indices for the left and right halves.
        It recursively divides the array into two halves until it reaches a base case. */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);// Recursively sort the left half
            mergeSort(arr, mid + 1, right);// Recursively sort the right half
            merge(arr, left, mid, right);// Merge the sorted halves back together
        }
    }
/*The custom merging process is based on the property of the input array. 
It checks if an element in the leftArr array is even and if an element in the rightArr array is odd. 
If both conditions are met, the element from the leftArr array is added to the original array.
 If the conditions are not met, the process checks which element is smaller and adds it to the original array. */
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];// It creates two new arrays to store the left and right halves of the array.
        int[] rightArr = new int[n2];
         for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] % 2 == 0 && rightArr[j] % 2 != 0) {
                arr[k++] = leftArr[i++];
            } else if (leftArr[i] % 2 != 0 && rightArr[j] % 2 == 0) {
                arr[k++] = rightArr[j++];
            } else {
                if (leftArr[i] <= rightArr[j]) {
                    arr[k++] = leftArr[i++];
                } else {
                    arr[k++] = rightArr[j++];
                }
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }//After the merge function is called recursively for the left and right halves of the array, the array is fully sorted.
    
}
