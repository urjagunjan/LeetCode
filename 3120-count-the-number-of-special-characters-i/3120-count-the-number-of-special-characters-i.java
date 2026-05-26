class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] seenchar=new boolean[128];
        int n=word.length();

        for(int i=0;i<n;i++){
            char mychar=word.charAt(i);
            seenchar[mychar]=true;
        }
        int i='a';
        int j='A';
        int count=0;
        while(i<='z' && j<='Z'){
            if(seenchar[i] && seenchar[j])count++;
            i++;
            j++;
        }

        return count;
    }
}