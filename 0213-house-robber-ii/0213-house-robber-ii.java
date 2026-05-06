class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        Integer[] dp1=new Integer[n+2];
        Integer[] dp2=new Integer[n+2];
        int ans=Math.max(helper(0,n-2,nums,dp1),helper(1,n-1,nums,dp2));
        return ans;
    }
    private int helper(int i,int j,int[] nums,Integer[] dp){
        if(i>j)return 0;

        if(dp[i]!=null)return dp[i];
        int rob=nums[i]+helper(i+2,j,nums,dp);
        int notrob=helper(i+1,j,nums,dp);

        return dp[i]=Math.max(rob,notrob);
    }

}