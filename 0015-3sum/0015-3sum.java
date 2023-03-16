class Solution {
 public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> listForReturn = new ArrayList<>();
        Set<List<Integer>> setForReturn = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1, hi = nums.length - 1, sum = -nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        List<Integer> innerList = new ArrayList<>(3);
                        innerList.add(nums[i]);
                        innerList.add(nums[lo]);
                        innerList.add(nums[hi]);
                        if (setForReturn.add(innerList)) {
                            listForReturn.add(innerList);
                        }
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return listForReturn;
    }
}