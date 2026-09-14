class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0)return false;
        
        sum/=2;
        dp=new Boolean[nums.length+1][sum+1];
        return solver(nums,0,sum);
    }
    private boolean solver(int[] nums,int i,int sum){
        if(sum==0)return true;
        if(sum<0)return false;
        if(i==nums.length)return false;

        if(dp[i][sum]!=null)return dp[i][sum];

        boolean pick =solver(nums,i+1,sum-nums[i]);
        boolean notpick=solver(nums,i+1,sum);

        return dp[i][sum]=pick||notpick;
    }
    
}
