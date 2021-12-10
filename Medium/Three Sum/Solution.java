class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort list -> Get pivot and 2Sum the rest
        
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();
        
        // If there are less than 3 elements, return an empty list (no triplets possible)
        if (nums.length < 3)
            return result;
        
        for (int pivot = 0; pivot < nums.length - 2; pivot++) {
            
            // Either pivot is first pivot (initial state) or it is different from previous pivot (avoids duplicate triplets)
            if (pivot == 0 || nums[pivot] != nums[pivot - 1]) {
                
                // 2Sum remaining elements
                int low = pivot + 1;        // low = Next element
                int high = nums.length - 1; // high = Last element
                int sum = 0 - nums[pivot];  // sum = Sum of high and low that would make 0 -> Make triplet
                
                while (low < high) {
                    // If pivot > 0, can never sum to 0 (because list is sorted)
                    if (nums[pivot] > 0) 
                        break;
                     
                    // If pivot + low + high = 0, add it to result list and skip duplicates
                    if (nums[low] + nums[high] == sum) {
                        // Add to results
                        result.add(Arrays.asList(nums[pivot], nums[low], nums[high]));
                        
                        // Skip low or high duplicates
                        while (low < high && nums[low] == nums[low + 1]) 
                            low++;
                        while (low < high && nums[high] == nums[high - 1])
                            high--;
                        
                        // Tighten both pointers since triplet already found (avoid duplicates)
                        low++;
                        high--;
                    }
                    else if (nums[low] + nums[high] < sum) {
                        // Skip duplicates
                        while (low < high && nums[low] == nums[low + 1]) 
                            low++;
                        
                        // Increment low since < sum -> need to increase
                        low++;
                    }
                    else if (nums[low] + nums[high] > sum) {
                        // Skip duplicates
                        while (low < high && nums[high] == nums[high - 1])
                            high--;
                        
                        // Decrement high since > sum -> need to decrease
                        high--;
                    }
                }
            }
        }
        return result;
    }
}