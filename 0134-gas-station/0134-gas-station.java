class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        long tot_sum=0;
        long curr_sum=0;
        int start_indx=0;
        for(int i=0;i<n;i++){
            tot_sum+=gas[i]-cost[i];
            curr_sum+=gas[i]-cost[i];
            if(curr_sum<0){
                start_indx=i+1;
                curr_sum=0;
            }

        }
        return (tot_sum<0)?-1:start_indx;
    }
}