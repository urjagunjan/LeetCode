class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] dp=new boolean[s.length()];
        int n=s.length();
        dp[0]=true;
        int reachable = 0;

        for (int i = 1; i < n; i++) {

            // add new reachable index
            if (i - minJump >= 0 && dp[i - minJump]) {
                reachable++;
            }

            // remove old index out of window
            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
                reachable--;
            }

            // current position can be reached
            if (reachable > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
    // private boolean solver(String s,int minJump,int maxJump,int i,int n,Boolean[] dp){
        
    //     if(i>n || s.charAt(i)!='0')return false;
    //     if(i==n)return true;

    //     if(dp[i]!=null)return dp[i];
        
    //     for (int jump = minJump; jump <= maxJump; jump++) {
    //         int next = i + jump;
    //         if (next <= n && solver(s, minJump, maxJump, next, n, dp)) {
    //             return dp[i] = true;
    //         }
            
    //     }

    //     return dp[i]=false;
    // }
}