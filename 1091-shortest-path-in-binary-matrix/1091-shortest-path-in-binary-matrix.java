class Solution {
    static int rowl;

    static int[] dr={-1,1,0,0,-1,-1,1,1};
    static int[] dc={0,0,-1,1,-1,1,-1,1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        rowl=grid.length;
        if(grid[0][0]!=0 || grid[rowl-1][rowl-1]!=0)return -1;
        return bfs(0,0,grid);
    }
    private static int bfs(int r,int c,int[][] grid){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {r,c,1});
        grid[r][c]=1;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            int k=curr[2];
            if(row==rowl-1 && col==rowl-1)return k;
            for(int i=0;i<8;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr>=0 &&  nr<rowl && nc>=0 && nc<rowl && grid[nr][nc]==0){
                    q.add(new int[] {nr,nc,k+1});
                    grid[nr][nc]=1;
                }
            }
        }
        return -1;
    }
}