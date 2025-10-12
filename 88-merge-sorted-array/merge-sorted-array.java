class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
                int i = m - 1; // the last elem in nums1
        int j = n - 1; // the last elem in nums2
        int k = m + n - 1; // the last position in nums1

        // We are walking from the end and fill up the largest elems
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i -= 1;
            } else {
                nums1[k] = nums2[j];
                j -= 1;
            }
            k -= 1;
        }
        // if nums2 has rested elems, it means all of them are the smallest
        while (j >= 0) {
            nums1[k] = nums2[j];
            j -= 1;
            k -= 1;
        }
    }
}