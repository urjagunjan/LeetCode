class Solution {
    public long maxAlternatingSum(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0],nums[1]);

        long sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum+=Math.max(nums[i]-nums[i-1],0);
        }
        return sum;
        
    }
}