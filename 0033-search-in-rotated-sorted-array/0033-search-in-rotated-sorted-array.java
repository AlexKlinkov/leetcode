class Solution {
    public int search(int[] nums, int target) {
        return Arrays.stream(nums).boxed().toList().indexOf(target);
    }
}