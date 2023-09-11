class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private static void generate(List<String> result, String current, int open, int close, int n) {
        if (current.length() == n * 2) {
            result.add(current); // Base case
            return;
        }
        if (open < n) {
            generate(result, current + "(", open + 1, close, n);
        }
        if (close < open) {
            generate(result, current + ")", open, close + 1, n);
        }
    }
}