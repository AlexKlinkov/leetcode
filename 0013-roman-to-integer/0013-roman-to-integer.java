class Solution {
    public int romanToInt(String s) {
       int answer = 0;
        char [] myString = s.toCharArray();
        HashMap<Character, Integer> mySymbolsAndTheirValues = new HashMap<>();
        mySymbolsAndTheirValues.put('I', 1);
        mySymbolsAndTheirValues.put('V', 5);
        mySymbolsAndTheirValues.put('X', 10);
        mySymbolsAndTheirValues.put('L', 50);
        mySymbolsAndTheirValues.put('C', 100);
        mySymbolsAndTheirValues.put('D', 500);
        mySymbolsAndTheirValues.put('M', 1000);
        int count = 0;
        while (count < s.length()) {
            boolean flag = true;
            if (count + 1 != s.length()) {
                if (myString[count] == 'I' && myString[count + 1] == 'V') {
                    answer += 4;
                    count += 2;
                    flag = false;
                } else if (myString[count] == 'I' && myString[count + 1] == 'X') {
                    answer += 9;
                    count += 2;
                    flag = false;
                } else if (myString[count] == 'X' && myString[count + 1] == 'L') {
                    answer += 40;
                    count += 2;
                    flag = false;
                } else if (myString[count] == 'X' && myString[count + 1] == 'C') {
                    answer += 90;
                    count += 2;
                    flag = false;
                } else if (myString[count] == 'C' && myString[count + 1] == 'D') {
                    answer += 400;
                    count += 2;
                    flag = false;
                } else if (myString[count] == 'C' && myString[count + 1] == 'M') {
                    answer += 900;
                    count += 2;
                    flag = false;
                }
            }
                if (flag) {
                    answer += mySymbolsAndTheirValues.get(myString[count]);
                    count += 1;
                }
        }
        return answer;
        
    }
}