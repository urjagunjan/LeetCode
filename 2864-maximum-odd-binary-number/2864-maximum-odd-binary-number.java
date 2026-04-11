class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb=new StringBuilder(s);
        int count1=0;
        int count0=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1')count1++;
            else count0++;
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<count1-1;i++){
            ans.append('1');
        }
        for(int i=0;i<count0;i++){
            ans.append('0');
        }
        ans.append('1');
        return ans.toString();
        
    }
}