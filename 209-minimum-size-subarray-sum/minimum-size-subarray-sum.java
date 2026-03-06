class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int leftIndex = 0;
        int rightIndex = 1;
        int currentLength = Integer.MAX_VALUE; // 1. take a big number as a current minimum length of a subarray
        int currentSum = nums[leftIndex]; // 2. take the first elem of a given array for checking condition ( >= target)

        while (leftIndex < rightIndex) { // 3. continue while the window is being saved
            if (currentSum >= target) { // 4. check the current sum of a subarray on corresponding to a target value

                if (rightIndex - leftIndex < currentLength) {
                    currentLength = rightIndex - leftIndex; // 5. refresh length of a subarray by new minimum value
                }
                currentSum -= nums[leftIndex++]; // 6. shift cursor to the right (from left position to the right one)

            } else {

                if (rightIndex < nums.length) {
                    currentSum += nums[rightIndex++]; // 7. expand a sliding window to the right
                } else {
                    currentSum -= nums[leftIndex++]; // 8. shrink a sliding window (put away values from the left)
                }
            }
        }

        return currentLength == Integer.MAX_VALUE ? 0 : currentLength;
    }
}