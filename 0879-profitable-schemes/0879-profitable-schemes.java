class Solution {
    private int minProfit;
    private int mod = 1000000007;
    private int helper(int [] group,int[] profit, int n, int idx, int currProfit, Integer [][][] dp){
        //if (currProfit>=minProfit) return 1;
        if(idx== group.length){
            if (currProfit>=minProfit) return 1;
            return 0;
        }
        if(dp[idx][n][currProfit]!=null) return dp[idx][n][currProfit];
        int take =0;
        if(group[idx]<=n) take = helper(group,profit,n-group[idx],idx+1,currProfit+profit[idx],dp) %mod;

        int notTake = helper(group,profit,n,idx+1,currProfit,dp)%mod;

        return dp[idx][n][currProfit]=take+notTake%mod;
    }
    public int profitableSchemes(int n, int mp, int[] group, int[] profit) {
        minProfit = mp;
        int total_profit=0;
        for(int p : profit) total_profit+=p;
        int len = group.length;
        Integer[][][] dp = new Integer[len][n+1][total_profit+1];
        return helper(group,profit,n,0,0,dp)%mod;
    }
}