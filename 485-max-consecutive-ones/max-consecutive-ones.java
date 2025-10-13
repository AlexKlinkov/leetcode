class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int largestConsecutiveOnes = 0;
        int currentCounterOfOnes = 0;

        for (Integer num : nums) {
            if (num == 1) {
                currentCounterOfOnes++;
                largestConsecutiveOnes = Math.max(currentCounterOfOnes, largestConsecutiveOnes);
            } else {
                currentCounterOfOnes = 0;
            }
        }
        
        return largestConsecutiveOnes;
    }
}