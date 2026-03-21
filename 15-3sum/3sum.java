class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 1. first of all sort the array in ascending approach as to reduce the time complexity from O(n³) to O(n²)
        Arrays.sort(nums);

        // 2. we are looking for two digital which in a sum gives zero if we plus it to the number[i] element
        for (int i = 0; i < nums.length - 2; i++) {

            // 3 skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 4.define the next variables:
            int leftIndex = i + 1; // 4.1 take a next element after nums[i] (the left pointer)
            int rightIndex = nums.length - 1; // 4.2 take the last element of the array (the right pointer)
            int target = -nums[i]; // 4.3 an iterable value of the array (transformation of 3Sum problem into 2Sum one)

            while (leftIndex < rightIndex) { // 5. continue loop while the pointers don't crash into each other
                int sum = nums[leftIndex] + nums[rightIndex]; // 6. define a variable for saving sum of the array elements

                if (sum == target) {
                    // 7. add a triplet that gives zero as the sum
                    result.add(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]));

                    // 8. skip duplicates for the leftIndex
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                        leftIndex++;
                    }

                    // 9. skip duplicates for the rightIndex
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
                        rightIndex--;
                    }

                    leftIndex++; // 10.1 move to the right, towards the center of the array
                    rightIndex--; // 10.2 move to the left, towards the center of the array

                } else if (sum < target) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }
        }
        return result;
    }
}