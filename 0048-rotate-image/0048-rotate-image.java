class Solution {
    public void rotate(int[][] matrix) {
        Queue<Integer> q=new LinkedList<>();
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                q.add(matrix[i][j]);
            }
        }
        for(int j=n-1;j>=0;j--){
            for(int i=0;i<n;i++){
                matrix[i][j]=q.poll();
            }
        }
    }
}