class Solution {
    public boolean canJump(int[] nums) {
        int maxindx=0;
        int i=0;
        while(i<=maxindx && i<nums.length-1){
            maxindx=Math.max(maxindx,i+nums[i]);
            if(maxindx>=nums.length-1)return true;
            i++;
        }
        return(maxindx>=nums.length-1);
    }
}