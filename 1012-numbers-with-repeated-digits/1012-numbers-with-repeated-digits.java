class Solution {
    Integer[][][][][] dp;
    static final int nmask=1024;
    public int numDupDigitsAtMostN(int n) {
        dp=new Integer[11][2][2][nmask][2];//index,tight,repeated,mask,lz
        return solver(String.valueOf(n),0,1,0,0,1);
    }
    private int solver(String s,int index,int tight,int repeated,int mask,int lz){
        if(index>=s.length())return repeated;
        if(dp[index][tight][repeated][mask][lz]!=null){
            return dp[index][tight][repeated][mask][lz];
        }
        int res=0;
        int lb=0;
        int ub=(tight==1)?s.charAt(index)-'0':9;
        for(int digit=lb;digit<=ub;digit++){
            int newtight=(tight==1 && digit==ub)?1:0;
            if(lz==1 && digit==0){
                res+=solver(s,index+1,newtight,repeated,mask,lz);
            }
            else{
                int isDigitused=1&(mask>>digit);
                int newrepeated=(repeated==1 || isDigitused==1)?1:0;
                int newmask=(1<<digit)|mask;
                res+=solver(s,index+1,newtight,newrepeated,newmask,0);
            }
            
        }
        return dp[index][tight][repeated][mask][lz]=res;
    }
}