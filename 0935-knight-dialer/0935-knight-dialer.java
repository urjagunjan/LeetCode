class Solution {
    static List<List<Integer>> adj;
    static Integer[][] dp;
    public int knightDialer(int n) {
        if(n==1)return 10;
        adj =new ArrayList<>();
        dp=new Integer[10][n+1];
        adj.add(Arrays.asList(6,4));
        adj.add(Arrays.asList(6,8));
        adj.add(Arrays.asList(7,9));
        adj.add(Arrays.asList(4,8));
        adj.add(Arrays.asList(3,9,0));
        adj.add(Arrays.asList());
        adj.add(Arrays.asList(1,7,0));
        adj.add(Arrays.asList(2,6));
        adj.add(Arrays.asList(1,3));
        adj.add(Arrays.asList(2,4));

        long count=0;
        for(int i=0;i<=9;i++){
            count+=dfs(i,n-1)%1_000_000_007;
        }
        return (int)(count%1_000_000_007);
        
    }
    public int dfs(int i,int n){
        if(n==0)return 1;
        if(dp[i][n]!=null)return dp[i][n];
        int count=0;
        if(!adj.get(i).isEmpty()){
            for(int num:adj.get(i)){
                count=(count+dfs(num,n-1))%1_000_000_007;
            }
        }
        return dp[i][n] = count%1_000_000_007;
    }
}