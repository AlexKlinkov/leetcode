class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1; // minimum is in the right half
            } else {
                right = mid; // minimum is in the left half (including mid)
            }
        }

        return nums[left];
    }

}