class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0;
        int maxCount = 0; // max frequency of any character in current window
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            // update frequency of current character
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            // update max frequency in current window
            maxCount = Math.max(maxCount, freqMap.get(rightChar));
            // if (window size - max frequency) > k, we need to shrink the window
            while ((right - left + 1) - maxCount > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}