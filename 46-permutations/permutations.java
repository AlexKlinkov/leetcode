class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0); // fills up the result step by step
        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] nums, int start) {
        // Base case:
        if (start == nums.length - 1) {
            // Converts array to list and add to result
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i); // swaps current index with i
            backtrack(result, nums, start + 1); // recursively generates permutations for the remaining elements
            swap(nums, start, i); // backtrack: swaps back to restore original array
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}