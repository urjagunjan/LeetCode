class Solution {
    Boolean[] dp;
    public boolean isMatch(String s, String p) {
        int i=s.length()-1;
        int j=p.length()-1;
        dp=new Boolean[i+1];
        return solver(s,p,i,j);
    }
    private boolean solver(String s,String p,int i,int j){
        
        if(i<0 && j<0)return true;

        if(j<0)return false;
        if(i<0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*')return false;
            }
            return true;
        }

        if(s.charAt(i)==p.charAt(j)|| p.charAt(j)=='?'){
            return solver(s,p,i-1,j-1);
        }
        if(dp[i]!=null)return dp[i];

        if(p.charAt(j)=='*'){

            boolean skipstar=solver(s,p,i,j-1);
            boolean notskipstar=solver(s,p,i-1,j);

            return dp[i]=skipstar||notskipstar;
        }

        return false;
    }
}