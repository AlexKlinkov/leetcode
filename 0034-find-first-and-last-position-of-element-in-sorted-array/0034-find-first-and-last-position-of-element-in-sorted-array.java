class Solution {
    public int[] searchRange(int[] nums, int target) {
        // brink cases
        if (nums.length == 0)
            return new int[]{-1, -1};
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            }
            return new int[]{-1, -1};
        }
        if (target < nums[0] || target > nums[nums.length - 1])
            return new int[]{-1, -1};
        // base cases, when array's length is 2 or more
        int arrLength = nums.length;
        int leftIndex = 0;
        int rightIndex = arrLength - 1;
        while (leftIndex <= rightIndex) {
            if (target > nums[leftIndex])
                leftIndex++;
            if (target < nums[rightIndex])
                rightIndex--;
            if (target == nums[leftIndex] && target == nums[rightIndex])
                return new int[]{leftIndex, rightIndex};
        }
        return new int[]{-1, -1};
    }
}