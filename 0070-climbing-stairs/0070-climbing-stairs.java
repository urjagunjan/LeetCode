class Solution {
    Integer[] dp;
    public int climbStairs(int n) {
        dp=new Integer[n+1];
        return helper(n);
    }
    private int helper(int n){
        if(n<0)return 0;
        if(n==0)return 1;
        if(dp[n]!=null)return dp[n];  
        int jump1=helper(n-1);
        int jump2=helper(n-2);
        return dp[n]=jump1+jump2;
    }
}