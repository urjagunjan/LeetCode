class Solution {
    static Integer[] dp;
    public int fib(int n) {
        dp=new Integer[n+1];
        return helper(n);
    }
    private int helper(int n){
        if(n<2)return n;
        if(dp[n]!=null)return dp[n];
        return dp[n]=fib(n-1)+fib(n-2);
    }
}