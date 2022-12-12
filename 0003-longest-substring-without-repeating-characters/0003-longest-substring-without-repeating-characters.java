class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int maxLengthOfSubString = 0;
        char[] elementsOfGotString = s.toCharArray();
        List<Character> intermediateSubstring = new ArrayList<>();
        int stepOnNextSymbol = 0;
        while (stepOnNextSymbol < elementsOfGotString.length) {
            if (!intermediateSubstring.contains(elementsOfGotString[stepOnNextSymbol])) {
                intermediateSubstring.add(elementsOfGotString[stepOnNextSymbol]);
                stepOnNextSymbol += 1;
            } else {
                if (intermediateSubstring.size() > maxLengthOfSubString) {
                    maxLengthOfSubString = intermediateSubstring.size();
                }
                stepOnNextSymbol -= (intermediateSubstring.size() - 1);
                intermediateSubstring.clear();
            }
        }
        if (intermediateSubstring.size() > maxLengthOfSubString) {
            maxLengthOfSubString = intermediateSubstring.size();
        }
        return maxLengthOfSubString;
    }
}