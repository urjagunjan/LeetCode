class Solution {
    int[] dr={-1,1,0,0};
    int[] dc={0,0,-1,1};
    int n;
    int m;
    public int numIslands(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid,int r,int c){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {r,c});
        grid[r][c]='0';
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            for(int i=0;i<4;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m &&grid[nr][nc]=='1'){
                    grid[nr][nc]='0';
                    q.offer(new int[] {nr,nc});
                }
            }
        }
    }
}