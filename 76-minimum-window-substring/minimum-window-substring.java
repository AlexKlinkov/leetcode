import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        if (!isSstringContainsAllLetterTstring(s, t))
            return "";

        return getResult(s, t);
    }

    private static String getResult(String s, String t) {
        int left = 0;
        int right = 0;
        String result = "";
        int minLength = Integer.MAX_VALUE;

        // Count characters in t
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        // Count characters in current window
        Map<Character, Integer> windowCount = new HashMap<>();
        int required = tCount.size();
        int formed = 0;

        while (right < s.length()) {
            // Add character at right pointer
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            // Check if we've met requirement for this character
            if (tCount.containsKey(c) && windowCount.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window while it's valid
            while (left <= right && formed == required) {
                // Update result if this window is smaller
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }

                // Remove character at left pointer
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                if (tCount.containsKey(leftChar) && windowCount.get(leftChar) < tCount.get(leftChar)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : result;
    }

    // checks that all symbol of 't' string contains in 's' string
    private static boolean isSstringContainsAllLetterTstring(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (!s.contains(t.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }
}