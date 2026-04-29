class Solution {
    public int mincap(int[] weights,int target,int l,int r){
        
        int ans=r;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(find(mid,weights)>target){
                l=mid+1;
            }
            else{
                ans=mid;
                r=mid-1;
            }
        }
        return ans;
    }
    public long find(int mid,int[] weights){
        long day=1;
        int clock=mid;
        for(int num:weights){
            if(num>clock){
                clock=mid-num;
                day++;
            }
            else{
                clock-=num;
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int w:weights){
            low=Math.max(low,w);
            high+=w;
        }
        int ans=mincap(weights,days,low,high);
        return ans;
    }
}