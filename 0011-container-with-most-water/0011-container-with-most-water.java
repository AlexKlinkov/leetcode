class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxVolumeOfPool = 0;
        int currentMaxValue = 0;
        while (left < right) {
            currentMaxValue = (right - left) * Integer.min(height[left], height[right]);
            maxVolumeOfPool = Integer.max(maxVolumeOfPool, currentMaxValue);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxVolumeOfPool;
    }
}