class Solution {
    public int sumOfSquares(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        int sum=0;
        for(int i=0;i<n;i++){
            if(n%(i+1)==0){
                sum+=(nums[i]*nums[i]);
            }
        }
        return sum;
    }
}