class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        int[] temp=new int[n*m];

        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[k]=grid[i][j];
                k++;
            }
        }

        Arrays.sort(temp);

        int rem=temp[0]%x;
        for(int val:temp){
            if(val%x!=rem)return -1;
        }
        int median=(temp.length)/2;
        median=temp[median];

        int count=0;
        for(int val:temp){
            count+=Math.abs(median-val)/x;
        }
        return count;   
    }
}