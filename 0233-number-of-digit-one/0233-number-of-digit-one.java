class Solution {
    Integer[][][] dp;
    public int countDigitOne(int n) {
        
        dp=new Integer[11][2][10];
        return solver(String.valueOf(n),0,1,0);
    }
    private int solver(String s,int index,int tight,int count1){
        if(index==s.length()){
            return count1;
        }
        if(dp[index][tight][count1]!=null)return dp[index][tight][count1];
        int lb=0;
        int ub=(tight==1)?s.charAt(index)-'0':9;
        int res=0;
        for(int digit=lb;digit<=ub;digit++){
            int newtight=(tight==1 && digit==ub)?1:0;
            if(digit==1){
                res+=solver(s,index+1,newtight,count1+1);
            }
            else{
                res+=solver(s,index+1,newtight,count1);
            }
            dp[index][tight][count1]=res;
        }
        return dp[index][tight][count1];
    }
}