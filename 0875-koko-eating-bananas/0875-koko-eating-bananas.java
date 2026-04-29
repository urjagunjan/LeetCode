class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for (int pile: piles) {
            max =Math.max(max, pile);
        }
        int k=findspeed(piles,h,1,max);
        return k;
    }
    public int findspeed(int[] piles,int target,int l,int r){
        int ans=r;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(find(mid,piles)>target){
                l=mid+1;
            }
            else{
                ans=mid;
                r=mid-1;
            }

        }
        return ans;
    }
    public long find(int mid,int[] piles){
        long hour=0;
        for(int banana:piles){
            hour+=(banana+mid-1)/mid;
        }
        return hour;
    }
}