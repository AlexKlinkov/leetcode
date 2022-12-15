class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] commonArray = new int[nums1.length + nums2.length];
        int position1 = 0;
        int position2 = 0;
        for (int i = 0; i < commonArray.length; i++) {
            if (position1 == nums1.length && position2 != nums2.length) {
                commonArray[i] = nums2[position2];
                position2++;
            } else if (position1 != nums1.length && position2 == nums2.length) {
                commonArray[i] = nums1[position1];
                position1++;
            } else if (nums1[position1] < nums2[position2]) {
                commonArray[i] = nums1[position1];
                position1++;
            } else {
                commonArray[i] = nums2[position2];
                position2++;
            }
        }
        if (commonArray.length % 2 != 0) {
            return commonArray[commonArray.length/2];
        } else {
            return (commonArray[commonArray.length/2] + commonArray[commonArray.length/2 - 1]) / 2.0;
        }
    }
}