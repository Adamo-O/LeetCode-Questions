class Solution {
    public int search(int[] nums, int target) {
        // Run binary search for minimum
        // Index of minimum is rotation pivot index
        // Ex. [4, 5, 6, 7, 0, 1, 2] -> minIndex = 4 -> rotated by 4
        
        int low = 0;
        int high = nums.length - 1;
        
        // Binary search for minimum
        while(low < high) {
            int mid = (low + high) / 2;
            // Minimum is in higher half
            if(nums[mid] > nums[high])
                low = mid + 1;
            // Minimum is in lower half
            else
                high = mid;
        }
        // low == high -> Minimum index & rotation size
        int rotation = low;

        // Reset low and high
        low = 0;
        high = nums.length - 1;
        
        // Normal binary search
        // Use % to account for rotation
        while (low <= high) {
            int rotatedMid = (low + high) / 2;
            // rotatedMid + rotation removes the rotation
            // % nums.length undoes the rotation to allow the correct indexing
            int mid = (rotatedMid + rotation) % nums.length;
            
            // Found target
            if (nums[mid] == target)
                return mid;
                
            // Not found, search in another half
            if (target > nums[mid])
                low = rotatedMid + 1;
            else
                high = rotatedMid - 1;
        }
        // Target not found in array
        return -1;
    }
}