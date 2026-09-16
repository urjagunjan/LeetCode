class Solution {
    Long[][] dp;
    public long maxAlternatingSum(int[] nums) {
        dp=new Long[nums.length][2];
        return solver(nums,0,0);
    }
    private long solver(int[] nums,int i,int plus){
        if(i>= nums.length)return 0;
        if(dp[i][plus]!=null){
            return dp[i][plus];
        }
        long notskip=0;
        if(plus==0){
            notskip=nums[i]+solver(nums,i+1,1);
        }
        else{
            notskip=-nums[i]+solver(nums,i+1,0);
        }
        long skip=solver(nums,i+1,plus);

        return dp[i][plus]=Math.max(notskip,skip);
    }
}