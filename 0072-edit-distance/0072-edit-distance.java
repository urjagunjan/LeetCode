class Solution {
    static int[][] dp;
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        dp=new int[n+1][m+1];
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int delete=dp[i-1][j]+1;
                    int insert=dp[i][j-1]+1;
                    int replace=dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(delete,Math.min(insert,replace));
                }
            }
            
        }
        return dp[n][m];

    }
    // private int helper(String word1,String word2,int i,int j){
    //     if(i<0)return j+1;
    //     if(j<0)return i+1;

    //     if(dp[i][j]!=null)return dp[i][j];

    //     if(word1.charAt(i)==word2.charAt(j)){
    //         return 0+helper(word1,word2,i-1,j-1); //is char at both my string is equal we do not need to perform any operation;
    //     }
    //     int insert=1+helper(word1,word2,i,j-1); //we are inserting a character hypothetically so the prev char in word1 will be char at i pos ;
    //     int delete=1+helper(word1,word2,i-1,j);
    //     int replace=1+helper(word1,word2,i-1,j-1);

    //     return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    // }
}