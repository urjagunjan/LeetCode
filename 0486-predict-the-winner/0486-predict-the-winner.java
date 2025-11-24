class Solution {
    public boolean predictTheWinner(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int result=helper(left,right,nums);
        return (result>=0)? true:false;
        
    }
    public int helper(int i,int j,int[] nums){
        if(i==j){
            return nums[i];
        }
        int leftpick=nums[i]-helper(i+1,j,nums);
        int rightpick=nums[j]-helper(i,j-1,nums);
        return Math.max(leftpick,rightpick);
    }
}