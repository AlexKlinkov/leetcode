class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] forReturn = {-1, -1};
        List<Integer> notSortedArray = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            notSortedArray.add(nums[k]);
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int firstValue = target - nums[i];
            int secondValue = target - firstValue;
            if (Math.abs(firstValue + secondValue) == Math.abs(target) && notSortedArray.contains(firstValue) &&
                    notSortedArray.contains(secondValue)) {
                forReturn[0] = notSortedArray.indexOf(firstValue);
                forReturn[1] = notSortedArray.lastIndexOf(secondValue);
                return forReturn;
            }
        }
        return forReturn; 
        
    }
}