class Solution {
    public int minimumDistance(int[] nums) {
        int maxi=(int)1e9;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]==nums[j] && nums[j]==nums[k]){
                        int temp= Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
                        maxi=Math.min(maxi,temp);
                    }
                }
            }
        }
        return maxi==(int)1e9?-1:maxi;
    }
}