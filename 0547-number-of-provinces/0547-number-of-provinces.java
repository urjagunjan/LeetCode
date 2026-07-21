class Solution {
    int[] parent;
    int[] rank;
    private int find(int x){
        if(parent[x]==x)return x;
        return find(parent[x]);
    }
    private void unionbyrank(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py)return;
        if(rank[x]>rank[y])parent[py]=px;
        else if(rank[y]>rank[x])parent[px]=py;
        else{
            parent[py]=px;
            rank[x]++;
        }
        return;
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        rank=new int[n+1];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    int x=i+1;
                    int y=j+1;
                    unionbyrank(x,y);
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(parent[i]==i)count++;
        }
        return count;
    }
}