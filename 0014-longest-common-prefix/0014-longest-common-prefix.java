class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = (String) Arrays.stream(strs).min(Comparator.comparingInt(String::length)).stream().toArray()[0];
        int count = 0;
        int amountOfRepeated = prefix.length();
        while (count <= amountOfRepeated){
            if (checkThatAllElemContainsPrefix(strs, prefix)) {
                return prefix;
            }
            prefix = prefix.substring(0, prefix.length() - 1);
            count++;
        }
        return "";
    }
    static boolean checkThatAllElemContainsPrefix(String[] elems, String prefix) {
        for (String str : elems) {
            if (!str.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}