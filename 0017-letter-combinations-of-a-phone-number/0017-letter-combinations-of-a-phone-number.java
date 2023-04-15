class Solution {
    public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) {
        return new ArrayList<>();
    }

    Map<Character, String> setOfWords = new HashMap<>();
    setOfWords.put('2', "abc");
    setOfWords.put('3', "def");
    setOfWords.put('4', "ghi");
    setOfWords.put('5', "jkl");
    setOfWords.put('6', "mno");
    setOfWords.put('7', "pqrs");
    setOfWords.put('8', "tuv");
    setOfWords.put('9', "wxyz");

    List<String> result = new ArrayList<>();
    generateCombinations(setOfWords, digits, 0, "", result);
    return result;
}

private void generateCombinations(Map<Character, String> setOfWords, String digits, int index, String current, List<String> result) {
    if (index == digits.length()) {
        result.add(current);
        return;
    }

    String letters = setOfWords.get(digits.charAt(index));
    for (int i = 0; i < letters.length(); i++) {
        generateCombinations(setOfWords, digits, index + 1, current + letters.charAt(i), result);
    }
}
}