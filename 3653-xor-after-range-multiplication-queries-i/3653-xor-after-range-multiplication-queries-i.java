class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int k=queries[i][2];
            int v=queries[i][3];
            while(l<=r){
                long ans=((nums[l]*1L*v)%1_000_000_007+1_000_000_007)%1_000_000_007;
                nums[l]=(int)ans;
                l+=k;
            }
        }
        int res=0;
        for(int i=0;i<nums.length;i++){
            res^=nums[i];
        }
        return res;
    }
}