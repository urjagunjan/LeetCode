class Solution {
    public String minWindow(String s, String t) {
        int[] map=new int[126];
        for(char c:t.toCharArray()){
            map[c]++;
        }
        int l=0;
        int r=0;
        int count=0;
        int minlen=Integer.MAX_VALUE;
        int startindx=0;
        while(r<s.length()){
            char rightchar=s.charAt(r);
            if(map[rightchar]>0){
                count++;
            }
            map[rightchar]--;
            r++;
            while(count==t.length()){
                if(r-l<minlen){
                    minlen=r-l;
                    startindx=l;
                }
                char leftchar=s.charAt(l);
                map[leftchar]++;
                if(map[leftchar]>0){
                    count--;
                }
                l++;
            }

        }
        if (minlen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(startindx, startindx + minlen);
    }
}