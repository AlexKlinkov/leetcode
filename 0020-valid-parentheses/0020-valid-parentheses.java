class Solution {
    public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    Map<Character, Character> map = new HashMap<>();
    map.put('(', ')');
    map.put('[', ']');
    map.put('{', '}');
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (map.containsKey(c)) {
            stack.push(c);
        } else if (stack.isEmpty() || map.get(stack.pop()) != c) {
            return false;
        }
    }
    return stack.isEmpty();
    }
}