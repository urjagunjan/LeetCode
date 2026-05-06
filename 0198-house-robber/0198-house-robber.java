class Solution {
    static Integer[] dp;
    public int rob(int[] nums) {
        dp=new Integer[nums.length];
        return helper(0,nums);
    }
    private int helper(int i,int[] nums){
        if(i>=nums.length)return 0;

        if(dp[i]!=null)return dp[i];

        int rob=nums[i]+helper(i+2,nums);
        int notrob=helper(i+1,nums);

        return dp[i]=Math.max(rob,notrob);
    }
}