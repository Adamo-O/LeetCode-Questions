/*
    Algorithm:
    Split array into sorted and unsorted subarrays
    Compare element to all previous, insert into correct position
    Repeat for all elements

    Complexity:
    Time: O(n^2) -> Compare 1 element to <= n elements n times -> n^2 
    Space: O(1) -> Constant number of variables
*/
public class InsertionSort {
    void sort(int arr[]) {
        int n = arr.length;

        // Index being compared = i
        for (int i = 1; i < n; ++i) {
            // Current element being compared
            int current = arr[i];

            // First index being shifted
            int target = i - 1;

            // Shift sorted values until element is at right position
            while (target >= 0 && current < arr[target]) {
                // Shift sorted elements by 1
                arr[target + 1] = arr[target];
                target -= 1;
            }

            // Element at correct position (not target since broke out of while loop) 
            arr[target + 1] = current;
        }
    }

    // Test methods
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver method
    public static void main(String args[])
    {
        int arr[] = {20, 17, 75, 7, 36};
 
        InsertionSort sorter = new InsertionSort();
        sorter.sort(arr);
 
        System.out.println("Sorted array:");
        printArray(arr);
    }

}
