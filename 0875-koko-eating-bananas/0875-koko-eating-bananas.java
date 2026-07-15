class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int pile:piles){
            max=Math.max(max,pile);
        }
        return min_speed(piles,h,1,max);
    }
    private int min_speed(int[] piles,int h,int s,int e){
        while(s<=e){
            int mid=s+(e-s)/2;

            long timetaken=checktime(piles,mid);
            if(timetaken>h){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return s;
    }
    private long checktime(int[] piles,int mid){
        long time=0;
        for(int pile:piles){
            time+=(pile+mid-1)/mid;
        }
        return time;
    }
}