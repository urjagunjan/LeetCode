import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : row1.toCharArray()) map.put(c, 1);
        for (char c : row2.toCharArray()) map.put(c, 2);
        for (char c : row3.toCharArray()) map.put(c, 3);
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            String lower = word.toLowerCase();
            int row = map.get(lower.charAt(0));
            boolean sameRow = true;
            
            for (char c : lower.toCharArray()) {
                if (map.get(c) != row) {
                    sameRow = false;
                    break;
                }
            }
            
            if (sameRow) result.add(word);
        }
        
        return result.toArray(new String[0]);
    }
}