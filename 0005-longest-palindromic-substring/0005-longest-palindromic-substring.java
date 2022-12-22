class Solution {
    public String longestPalindrome(String s) {
        if (s.length() > 1000 || s.length() == 1 || s.equals(new StringBuilder(s).reverse().toString())) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder first = new StringBuilder(getPalindrome(s, i, i));
            StringBuilder second = new StringBuilder(getPalindrome(s, i, i + 1));
            if (first.length() > result.length()) {
                result = first;
            }
            if (second.length() > result.length()) {
                result = second;
            }
        }
        return result.toString();
    }
    public static String getPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.toCharArray()[left] == s.toCharArray()[right]){
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}