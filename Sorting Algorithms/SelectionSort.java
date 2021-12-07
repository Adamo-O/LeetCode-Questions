/*
    Algorithm:
    Unsorted and sorted subarrays
    Find min of unsorted subarray, move to end of sorted subarray
    Repeat until sorted
    
    Complexity:
    Time: O(n^2) -> Two nested for loops over n
    Space: O(1) -> Constant number of variables
*/

class SelectionSort {
    void sort(int arr[]) {
        int n = arr.length;

        // Move bound of unsorted array
        for (int bound = 0; bound < n - 1; bound++) {
            // Find min of unsorted array
            int min = bound;

            // Minimum function
            for (int i = bound + 1; i < n; i++) {
                if (arr[i] < arr[min])
                    min = i;
            }

            // Swap minimum with bound (now the smallest)
            int temp = arr[min];
            arr[min] = arr[bound];
            arr[bound] = temp;
        }
    }

    void printArr(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[]args){
        SelectionSort sort = new SelectionSort();
        int arr[] = {65, 34, 54, 22, 11, 21};
        sort.sort(arr);
        System.out.println("Sorted array:");
        sort.printArr(arr);
    }
}
