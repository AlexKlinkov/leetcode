class NumArray {

    int[] nums;
    
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        int[] prefixSumArray = new int[this.nums.length]; // create a prefix sum array
        prefixSumArray[0] = this.nums[0]; // step1 (the first elem of a new array is the same as it's in original one)
        for (int i = 1; i < prefixSumArray.length; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + this.nums[i]; // step1 + nums[i], step2 + nums[i], step3 nums[i]...
        }
        return left == 0 ? prefixSumArray[right] : prefixSumArray[right] - prefixSumArray[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */