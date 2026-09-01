class NumArray {
    int[] segment;
    int n;
    public NumArray(int[] nums) {
        segment=new int[4*nums.length];
        n=nums.length;
        build(0,nums,0,n-1);
        
    }
    public void build(int node,int[] nums,int l,int r){
        if(l==r){
            segment[node]=nums[l];
            return;
        }
        int mid=l+(r-l)/2;
        build(2*node+1,nums,l,mid);
        build(2*node+2,nums,mid+1,r);
        segment[node]=segment[2*node+1]+segment[2*node+2];
    }
    
    public void update(int index, int val) {
        updatemodify(0,index,val,0,n-1);
    }
    public void updatemodify(int node,int index,int val,int l,int r){
        if(l==r){
            segment[node]=val;
            return;
        }
        int mid=l+(r-l)/2;
        if(index<=mid){
            updatemodify(2*node+1,index,val,l,mid);
        }
        else{
            updatemodify(2*node+2,index,val,mid+1,r);
        }
        segment[node]=segment[2*node+1]+segment[2*node+2];
    }
    
    public int sumRange(int left, int right) {
        return find(0,0,n-1,left,right);
    }
    public int find(int node,int start,int end,int l,int r){
        if(start>r || end<l){
            return 0;
        }
        if(l<=start && end<=r){
            return segment[node];
        }
        int mid=start+(end-start)/2;
        int le=find(2*node+1,start,mid,l,r);
        int ri=find(2*node+2,mid+1,end,l,r);
        return le+ri;

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */