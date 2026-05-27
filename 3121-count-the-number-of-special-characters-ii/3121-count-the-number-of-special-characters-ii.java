class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastlower=new int[26];
        int[] firstupper=new int[26];
        int n=word.length();
        int count=0;

        Arrays.fill(lastlower,-1);
        Arrays.fill(firstupper,-1);

        for(int i=0;i<n;i++){
            char c=word.charAt(i);
            if(c>='a' && c<='z'){
                lastlower[c-'a']=i;
            }
            else{
                if(firstupper[c-'A']==-1){
                    firstupper[c-'A']=i;
                }
            }
        }

        for(int i=0;i<26;i++){
            if(firstupper[i]!=-1 && lastlower[i]!=-1){
                if(lastlower[i]<firstupper[i])count++;
            }
        }
        return count;
    }
}