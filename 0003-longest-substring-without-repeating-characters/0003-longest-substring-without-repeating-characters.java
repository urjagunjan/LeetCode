class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> output=new HashSet<>();
        int maxlength=0;
        int left=0;
        int right= 0;
        while(right<s.length()){
            char c=s.charAt(right);
            if(!output.contains(c)){
                output.add(c);
                maxlength=Math.max(maxlength,right-left+1);
                right++;
            }
            else{
                output.remove(s.charAt(left));
                left++;
            }
        }
        return maxlength;
        
    }
}