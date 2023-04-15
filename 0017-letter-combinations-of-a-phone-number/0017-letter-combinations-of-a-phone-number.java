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
        if (digits.length() == 1) {
            String resultString = setOfWords.get(digits.charAt(0));
            List<String> result = new ArrayList<>();
            for (int i = 0; i < resultString.length(); i++) {
                result.add(String.valueOf(resultString.charAt(i)));
            }
            return result;
        }
        List<String> result = new ArrayList<>();
        int n = digits.length();
        switch (n) {
            case 2:
                StringBuilder first = new StringBuilder(setOfWords.get(digits.charAt(0)));
                StringBuilder second = new StringBuilder(setOfWords.get(digits.charAt(1)));
                for (int i = 0; i < setOfWords.get(digits.charAt(0)).length(); i++) {
                    for (int j = 0; j < setOfWords.get(digits.charAt(1)).length(); j++) {
                        result.add(first.charAt(i) + String.valueOf(second.toString().charAt(j)));
                    }
                }
                break;
            case 3:
                first = new StringBuilder(setOfWords.get(digits.charAt(0)));
                second = new StringBuilder(setOfWords.get(digits.charAt(1)));
                StringBuilder third = new StringBuilder(setOfWords.get(digits.charAt(2)));
                for (int i = 0; i < first.length(); i++) {
                    for (int j = 0; j < second.length(); j++) {
                        for (int k = 0; k < third.length(); k++) {
                            result.add(first.charAt(i) + String.valueOf(second.toString().charAt(j)) +
                                    third.toString().charAt(k));
                        }
                    }
                }
                break;
            case 4:
                first = new StringBuilder(setOfWords.get(digits.charAt(0)));
                second = new StringBuilder(setOfWords.get(digits.charAt(1)));
                third = new StringBuilder(setOfWords.get(digits.charAt(2)));
                StringBuilder forth = new StringBuilder(setOfWords.get(digits.charAt(3)));
                for (int i = 0; i < first.length(); i++) {
                    for (int j = 0; j < second.length(); j++) {
                        for (int k = 0; k < third.length(); k++) {
                            for (int l = 0; l < forth.length(); l++) {
                                result.add(first.charAt(i) + String.valueOf(second.toString().charAt(j)) +
                                        third.toString().charAt(k) + forth.toString().charAt(l));
                            }
                        }
                    }
                }
                break;
        }
        return result;
    }
}