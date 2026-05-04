class Solution {
    static Integer[][] dp;
    public int minDistance(String word1, String word2) {
        int i=word1.length()-1; //index of word1
        int j=word2.length()-1; // index of word2
        dp=new Integer[i+1][j+1];
        int minimum=helper(word1,word2,i,j);
        return minimum;
    }
    private int helper(String word1,String word2,int i,int j){
        if(i<0)return j+1;
        if(j<0)return i+1;

        if(dp[i][j]!=null)return dp[i][j];

        if(word1.charAt(i)==word2.charAt(j)){
            return 0+helper(word1,word2,i-1,j-1); //is char at both my string is equal we do not need to perform any operation;
        }
        int insert=1+helper(word1,word2,i,j-1); //we are inserting a character hypothetically so the prev char in word1 will be char at i pos ;
        int delete=1+helper(word1,word2,i-1,j);
        int replace=1+helper(word1,word2,i-1,j-1);

        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }
}