class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int left=0;
        int right=n-1;
        while(n>0){
            for(int i=0;i<n-1;i++){
                int temp=matrix[left][left+i];
                matrix[left][left+i]=matrix[right-i][left];
                matrix[right-i][left]=matrix[right][right-i];
                matrix[right][right-i]=matrix[left+i][right];
                matrix[left+i][right]=temp;
            }
            left++;
            right--;
            n-=2;
        }
    }
}