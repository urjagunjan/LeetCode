class Solution {
    int m;
    int n;
    int[] dr={-1,1,0,0};
    int[] dc={0,0,-1,1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m=heights.length;
        n=heights[0].length;
        boolean[][] atlanticreachable=new boolean[m][n];
        boolean[][] pacificreachable=new boolean[m][n];
        List<List<Integer>> res=new ArrayList<>(); 
        for(int i=0;i<n;i++){
            if(!pacificreachable[0][i])
            bfs(heights,0,i,pacificreachable);
        }
        for(int i=0;i<m;i++){
            if(!pacificreachable[i][0])
            bfs(heights,i,0,pacificreachable);
        }
        for(int i=0;i<n;i++){
            if(!atlanticreachable[m-1][i])
            bfs(heights,m-1,i,atlanticreachable);
        }
        for(int i=0;i<m;i++){
            if(!atlanticreachable[i][n-1])
            bfs(heights,i,n-1,atlanticreachable);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(atlanticreachable[i][j] && pacificreachable[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void bfs(int[][] heights,int row,int col,boolean[][] waterreached){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{row,col});
        waterreached[row][col]=true;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nc>=0 && nr<m && nc<n && heights[nr][nc]>=heights[r][c] && !waterreached[nr][nc]){
                    waterreached[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}