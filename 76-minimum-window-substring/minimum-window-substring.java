class Solution {
    public String minWindow(String s, String t) {
if (s.length() < t.length()) return "";
    
    // 1. Считаем, сколько каких букв нужно
    int[] need = new int[128];
    for (char c : t.toCharArray()) need[c]++;
    
    // 2. need[c] > 0 - буква нужна
    //    need[c] == 0 - не нужна
    //    need[c] < 0 - нашли лишнюю
    
    int left = 0, right = 0;
    int minLeft = 0, minLength = Integer.MAX_VALUE;
    int missing = t.length(); // Сколько букв еще не нашли
    
    while (right < s.length()) {
        // 3. Добавляем правую букву
        char rightChar = s.charAt(right);
        
        // Если эта буква нужна
        if (need[rightChar] > 0) {
            missing--; // Нашли одну нужную
        }
        
        // Уменьшаем счетчик (может стать отрицательным)
        need[rightChar]--;
        right++;
        
        // 4. Пока нашли все буквы
        while (missing == 0) {
            // 5. Запоминаем минимальное окно
            if (right - left < minLength) {
                minLength = right - left;
                minLeft = left;
            }
            
            // 6. Убираем левую букву
            char leftChar = s.charAt(left);
            need[leftChar]++; // Возвращаем букву
            
            // Если это была нужная буква и теперь ее не хватает
            if (need[leftChar] > 0) {
                missing++;
            }
            
            left++;
        }
    }
    
    return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}