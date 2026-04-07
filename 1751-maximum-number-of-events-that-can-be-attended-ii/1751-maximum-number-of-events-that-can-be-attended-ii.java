class Solution {
    static Integer[][] dp;
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        dp=new Integer[events.length][k+1];
        int ans=solver(0,0,events,k);
        return ans;
    }
    public int solver(int indx,int et,int[][] events,int k){
        if(k==0 || indx>=events.length){
            return 0;
        }
        if(dp[indx][k]!=null)return dp[indx][k];
        int nextindx=binarysearch(events,events[indx][1]);
        int take=events[indx][2]+solver(nextindx,events[indx][1],events,k-1);
        int nottake=solver(indx+1,et,events,k);
        return dp[indx][k]=Math.max(take,nottake);
    }
    public int binarysearch(int[][] events,int target){
        int left=0;
        int right=events.length;

        while(left<right){
            int mid=left+(right-left)/2;

            if(events[mid][0]>target){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
        
    }
}