class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        // a map with key-symbol of 't' string and value-frequency of meeting
        Map<Character, Integer> tMap = t.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1, // k - the char itself, v - starts as 1
                        (existing, replacement) -> existing + 1)); // merge duplicates

        int left = 0;
        int right = 0;
        int countOfCondition = tMap.size();
        int countCollectedAccomplishedConditions = 0;
        String result = "";
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> windowMap = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            if (tMap.containsKey(rightChar) && windowMap.get(rightChar).equals(tMap.get(rightChar))) {
                countCollectedAccomplishedConditions++;
            }

            while (countCollectedAccomplishedConditions == countOfCondition) {
                if (right - left + 1 < minLength) {
                    minLength = right - left +  1;
                    result = s.substring(left, right + 1);
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar))
                    countCollectedAccomplishedConditions--;

                left++;
            }
            right++;
        }
        return result;
    }
}