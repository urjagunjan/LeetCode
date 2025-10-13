class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int Min=Integer.MAX_VALUE;
        if(nums.length==1){
            Min=nums[0];
            return Min;
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<nums[end]){
                Min=Math.min(Min,nums[mid]);
                end=mid;
            }
            else if(nums[mid]>nums[end]){
                Min=Math.min(Min,nums[start]);
                start=mid+1;
            }
            else{
                Min=Math.min(Min,nums[mid]);
                end--;
            }
            
        }
        return Min;
    }
}