class Solution {
    static Integer[][][] dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp=new Integer[m+1][target+1][n+2];
        int res=solver(0,target,-1,houses,cost,m,n);
        return (res>=(int)1e9)?-1:res;
    }
    public int solver(int indx,int target,int prev,int[] houses,int[][] cost,int m,int n){
        if(target<0)return (int)1e9;
        if(indx==m && target==0)return 0;
        if(indx==m && (target<0 || target>0))return (int)1e9;
        if(dp[indx][target][prev+1]!=null)return dp[indx][target][prev+1];
        int res=(int)1e9;
        if(houses[indx]!=0){
            int newtarget=target-((houses[indx]!=prev)?1:0);
            res=solver(indx+1,newtarget,houses[indx],houses,cost,m,n);
        }
        else{
            for(int i=0;i<n;i++){
                int color=i+1;
                int newtarget = target - ((color != prev) ? 1 : 0);
                
                res=Math.min(res,cost[indx][i]+solver(indx+1,newtarget,color,houses,cost,m,n));
            }
        }
        
        return dp[indx][target][prev+1]=res;
    }
}