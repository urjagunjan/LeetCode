class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            int maxlen=-(int)1e9;
            for(int j=0;j<m;j++){
                String temp=String.valueOf(grid[j][i]);
                maxlen=Math.max(maxlen,temp.length());
            }
            arr[i]=maxlen;
        }
        return arr;
    }
}