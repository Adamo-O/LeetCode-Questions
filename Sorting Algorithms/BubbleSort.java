/*
    Algorithm:
    Swap adjacent elements if they are in the wrong order

    Complexity:
    Time: O(n^2) -> Two nested for loops
    Space: O(1) -> Constant number of variables
*/
public class BubbleSort {
    void sort(int arr[]) {
        int n = arr.length;

        // Pivot pointer i
        for (int i = 0; i < n - 1; i++) {

            // Leading pointer j
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Test methods
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver method to test above
    public static void main(String args[])
    {
        BubbleSort sorter = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        sorter.sort(arr);
        System.out.println("Sorted array:");
        sorter.printArray(arr);
    }

}
