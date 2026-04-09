class Solution {
    static Integer[][] dp;
    public int maxSizeSlices(int[] slices) {
        int n=slices.length;
        int k=n/3;
        if(n==0)return 0;
        dp=new Integer[n+1][k+1];
        int case1=solver(0,k,n-1,slices);
        dp=new Integer[n+1][k+1];
        int case2=solver(1,k,n,slices);
        return Math.max(case1,case2);
   }
   public int solver(int indx,int k,int len,int[] slices){
        if(k==0)return 0;
        if(indx>=len)return -(int)1e9;
        if(dp[indx][k]!=null)return dp[indx][k];
        int take=slices[indx]+solver(indx+2,k-1,len,slices);
        int nottake=solver(indx+1,k,len,slices);
        return dp[indx][k]=Math.max(take,nottake);
   }
}