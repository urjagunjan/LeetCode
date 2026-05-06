class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+2];
        dp[n]=0;
        dp[n+1]=(int)1e9;
        for(int i=n-1;i>=0;i--){
            dp[i]=Math.min(dp[i+1],dp[i+2])+cost[i];
        }
        return Math.min(dp[0],dp[1]);
    }
    // private int func(int i,int[] cost){
    //     if(i>cost.length)return (int)1e9;
    //     if(i==cost.length)return 0;

    //     if(dp[i]!=null)return dp[i];

    //     int jump1=cost[i]+func(i+1,cost);
    //     int jump2=cost[i]+func(i+2,cost);
    //     return dp[i]=Math.min(jump1,jump2);
    // }
}