class Solution {
    private Integer[][][][] dp;
    private int solver(int[][] grid,int r1,int c1,int r2,int c2){
        if(r1>=grid.length || c1>=grid.length || r2>=grid.length || c2>=grid.length || grid[r1][c1]==-1 || grid[r2][c2]==-1 ) return -(int)1e8;
        if(r1==grid.length-1 && c1==grid.length-1)return grid[r1][c1];
        if(dp[r1][c1][r2][c2]!=null){
            return dp[r1][c1][r2][c2];
        }
        int cherry=0;
        if(r1==r2 && c1==c2){
            cherry=grid[r1][c1];
        }
        else
        cherry=grid[r1][c1]+grid[r2][c2];
        int rightright=solver(grid,r1,c1+1,r2,c2+1);
        int rightdown=solver(grid,r1,c1+1,r2+1,c2);
        int downdown=solver(grid,r1+1,c1,r2+1,c2);
        int downright=solver(grid,r1+1,c1,r2,c2+1);
        return dp[r1][c1][r2][c2]=cherry+Math.max(Math.max(rightdown,rightright),Math.max(downdown,downright));

    }
    public int cherryPickup(int[][] grid) {
        dp=new Integer[grid.length][grid.length][grid.length][grid.length];
        int ans= solver(grid,0,0,0,0);
        return ans<0?0:ans;
    }
}