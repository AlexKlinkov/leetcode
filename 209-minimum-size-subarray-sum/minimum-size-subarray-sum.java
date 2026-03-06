class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int leftIndex = 0;
        int rightIndex = 1;
        int currentMinLengthOfSubArray = Integer.MAX_VALUE;
        int currentSum = nums[leftIndex]; // takes the first elem of a given array

        while(leftIndex < rightIndex){

            if (currentSum >= target){
                if (rightIndex - leftIndex < currentMinLengthOfSubArray) {
                    currentMinLengthOfSubArray = rightIndex - leftIndex;
                }
                currentSum -= nums[leftIndex++];
            } else {
                
                if (rightIndex < nums.length) {
                    currentSum += nums[rightIndex++];
                } else {
                    currentSum -= nums[leftIndex++];
                }
            }
        }

        return currentMinLengthOfSubArray ==  Integer.MAX_VALUE ? 0 : currentMinLengthOfSubArray;
    }
}