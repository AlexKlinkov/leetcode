class Solution {
    public int trap(int[] height) {
        // 1. define necessary variables
        int left = 0; // a left pointer, which goes to the right side
        int right = height.length - 1; // a right pointer, which goes to the left side
        int maxLeft = 0; // the highest wall for the leftPointer
        int maxRight = 0; // the highest wall for the rightPointer
        int totalWater = 0; // accumulates total amount of water, which can be trapped

        while (left < right) { // 2. continue loop while the pointers don't crash into each other
            // 3. find the smallest wall in the array
            if (height[left] < height[right]) {
                // 4. define a possible to trap some water at left side
                if (height[left] >= maxLeft) {
                    maxLeft = height[left]; // 5. update max, the water wasn't trapped
                } else {
                    totalWater += maxLeft - height[left]; // 6. the water was trapped
                }
                left++; // 7. move to the right direction
            } else {
                // 8. define a possible to trap some water at right side
                if (height[right] >= maxRight) {
                    maxRight = height[right]; // 9. update max, the water wasn't trapped
                } else {
                    totalWater += maxRight - height[right]; // 10. the water was trapped
                }
                right--; // 11. move to the left direction
            }
        }
        return totalWater;
    }
}