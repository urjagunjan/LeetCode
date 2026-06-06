class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] prefixsum=new int[nums.length];
        int[] suffixsum=new int[nums.length];
        int n=nums.length;
        prefixsum[0]=nums[0];
        for(int i=1;i<n;i++){
            prefixsum[i]=nums[i]+prefixsum[i-1];
        }
        suffixsum[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffixsum[i]=nums[i]+suffixsum[i+1];
        }
        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            answer[i]=Math.abs(prefixsum[i]-suffixsum[i]);
        }
        return answer;
    }
}