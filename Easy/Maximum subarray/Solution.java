class Solution {
    public int maxSubArray(int[] nums) {
        // Normal max algorithm, except current sum resets to 0 if an element would make sum negative

        // Initialize max to min value (-INF), sum to 0 (will never be < 0)
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        // Add each value to sum, update max, reset sum to 0 if < 0
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}