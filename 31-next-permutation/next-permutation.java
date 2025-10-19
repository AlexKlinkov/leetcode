class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) // check the edge case, when array nums has a length equal to 1
            return;
        // check the edge case, when numbers are already sorted by descent
        if (IntStream.range(0, nums.length - 1).allMatch(index -> nums[index] >= nums[index + 1])) {
            Arrays.sort(nums);
            return;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                // 1. find the smallest number from right, which bigger than nums[i]
                int j = nums.length - 1;
                while (j > i && nums[j] <= nums[i]) {
                    j--; // the pointer of the smallest number
                }
                // 2. do permutation
                int savedValue = nums[i];
                nums[i] = nums[j];
                nums[j] = savedValue;
                // 3. sort array from (i + 1) to the end
                Arrays.sort(nums, i + 1, nums.length);
                break; // do only one permutation
            }
        }
    }
}