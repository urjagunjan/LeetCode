class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+2];
        dp[1]=1;
        for(int i=2;i<=n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n+1];
    }
    // private int helper(int n){
    //     if(n<0)return 0;
    //     if(n==0)return 1;
    //     if(dp[n]!=null)return dp[n];  
    //     int jump1=helper(n-1);
    //     int jump2=helper(n-2);
    //     return dp[n]=jump1+jump2;
    // }
}