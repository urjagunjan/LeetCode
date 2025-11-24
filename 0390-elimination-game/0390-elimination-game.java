class Solution {
    public int lastRemaining(int n) {
        return helper(1,1,n,true);
    }
    public int helper(int head,int step,int n,Boolean left){
        if(n==1){
            return head;
        }
        if(left || n%2==1){
            head=head+step;
            n=n/2;
            step=step*2;
            return helper(head,step,n,!left);
        }
        n=n/2;
        step=step*2;
        return helper(head,step,n,!left);
    }
}