class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0); // fills up the result step by step
        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] nums, int start) {
        // Base case:
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();

            for (int num : nums) {
                list.add(num);
            }

            result.add(list);
            return;
        }

        for(int i = start; i < nums.length; i++) {
            swap(nums, i, start); // swaps current index with i
            backtrack(result, nums, start + 1); // recursively generates permutations for the remaining elements
            swap(nums, start,  i); // a back swap to return as it was
        }
    }

    private static void swap(int[] nums, int i, int start) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }
}