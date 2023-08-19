class Solution {
    public int removeElement(int[] nums, int val) {
    int k = 0; // Initialize a counter for elements not equal to val

    // Iterate through the array
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
            nums[k] = nums[i]; // Move the element not equal to val to the front
            k++; // Increment the count
        }
    }

    return k; // k represents the number of elements not equal to val
    }
}