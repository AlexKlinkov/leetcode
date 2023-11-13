class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 1)
            return target <= nums[0] ? 0 : 1;
        int left = 0;
        int mid = nums.length % 2 == 0 ? (nums.length / 2) : (nums.length / 2) + 1;
        int maxAmount = mid;
        int right = nums.length - 1;
        int count = 0;
        while (count <= maxAmount) {
            switch (targetIsMidOrMoreOrLessThanMid(target, nums[mid])) {
                case "equal":
                    return mid;
                case "bigger":
                    left = mid;
                    mid = (right - left) == 1 ? (right + left) / 2 + 1 : (right + left) / 2;
                    break;
                case "smaller":
                    right = mid;
                    mid = (right + left) / 2;
                    break;
                default:
                    break;
            }
            count++;
        }
        return nums[mid] > target ? mid : mid + 1;
    }
    private String targetIsMidOrMoreOrLessThanMid(int target, int midValue) {
        if (target == midValue) {
            return "equal";
        } else if (target > midValue) {
            return "bigger";
        } else {
            return "smaller";
        }
    }
}