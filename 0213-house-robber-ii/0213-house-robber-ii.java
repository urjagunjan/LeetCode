class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int [] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int max_1=helper(dp,nums,1,nums.length);
        Arrays.fill(dp,-1);
        
        int max_2=helper(dp,nums,0,nums.length-1);
        return Math.max(max_1,max_2);
    }
    public int helper(int[] dp,int [] nums,int indx,int length){
        if(indx>=length) return 0;
        if(dp[indx]!=-1) return dp[indx];
        int include=nums[indx]+helper(dp,nums,indx+2,length);
        int exclude=helper(dp,nums,indx+1,length);
        
        return dp[indx]=Math.max(include,exclude);

    }
}