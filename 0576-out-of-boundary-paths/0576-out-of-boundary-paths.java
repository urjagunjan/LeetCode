class Solution {
    static int mod=1_000_000_007;
    static Long[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new Long[m+1][n+1][maxMove+1];
        return (int)solver(m,n,startRow,startColumn,maxMove);
        // return (int)dp[m][n][maxMove];
    }
    private long solver(int m,int n,int r,int c,int move){
        if(r<0 || r>=m || c<0 || c>=n)return 1;
        if(move<=0){
            return (r<0 || r>=m || c<0 || c>=n)?1:0;
        }
        if(dp[r][c][move]!=null) return dp[r][c][move];
        long right=solver(m,n,r,c+1,move-1)%mod;
        long left=solver(m,n,r,c-1,move-1)%mod;
        long down=solver(m,n,r+1,c,move-1)%mod;
        long up=solver(m,n,r-1,c,move-1)%mod;
        return dp[r][c][move]=((right+left)%mod+(down+up)%mod)%mod;
    }
}