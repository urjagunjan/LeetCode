class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        
        int left = 0;
        int right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (map[rightChar] > 0) {
                count++;
            }
            map[rightChar]--;
            right++;
            
            while (count == t.length()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }
                
                char leftChar = s.charAt(left);
                map[leftChar]++;
                if (map[leftChar] > 0) {
                    count--;
                }
                left++;
            }
        }
        
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(startIndex, startIndex + minLen);
    }
}