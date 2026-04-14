class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int left=start;
        int right=start;
        while(left>=0 || right<nums.length){
            if(left>=0){
                if(nums[left]==target)return Math.abs(left-start);
            }
            left--;
            if(right<nums.length){
                if(nums[right]==target)return Math.abs(right-start);
            }
            right++;
        }
        return 0;
    }
}