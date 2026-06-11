class Solution {
    static int rowl;
    static int coll;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    class Pair{
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int maxtime=0;
        rowl=grid.length;
        coll=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int countfresh =0;
        // add alll rotten oranges into queue;
        for(int i=0;i<rowl;i++){
            for(int j=0;j<coll;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));// row,col,time;
                }
                if(grid[i][j]==1){
                    countfresh++;
                }
            }
        }
        if(countfresh==0){
            return 0;
        }
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int t=curr.time;

            maxtime=Math.max(maxtime,t);
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];

                // valid case
                if(nr>=0 && nr<rowl && nc>=0 &&  nc<coll && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    countfresh--;
                    q.offer(new Pair(nr,nc,t+1));
                }
            }
        }
        return (countfresh==0)?maxtime:-1;
    }
}