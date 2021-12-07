class Container_with_most_water {
    public int maxArea(int[] height) {
        
        // Initialize left, right and max area
        int leftEnd = 0, rightEnd = height.length - 1;
        int maxArea = 0;
        
        while (leftEnd < rightEnd) {
            // Find max of water area (width = right - left, height = lowest of left and right heights)
            maxArea = Math.max(maxArea, (rightEnd - leftEnd) * Math.min(height[leftEnd], height[rightEnd]));
            
            // Since we start with the largest width (both extremes), only increment smaller height
            if (height[rightEnd] > height[leftEnd])
                leftEnd++;
            else
                rightEnd--;
        }
        
        return maxArea;
    }
}