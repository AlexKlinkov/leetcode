class Solution {
    public boolean isPalindrome(String s) {
        // 1. remove all non-alphanumeric characters and convert to lowercase
        var cleanedS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int leftPointer = 0; // 2. it moves from the left to the right
        int rightPointer = cleanedS.length() - 1; // 3. it moves from the right to the left

        // 4. continue to check before pointers don't point at the same character
        while (leftPointer < rightPointer) {
            // 5. after each iteration left pointer is incremented and right pointer is decremented
                // so they are moving to direction to each other (to the center)
            if (cleanedS.charAt(leftPointer++) != cleanedS.charAt(rightPointer--)) {
                return false; // 6. it there is at least the one symbol doesn't match
            }

        }

        return true;
    }
}