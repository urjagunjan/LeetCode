class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.')continue;
                char ch=board[i][j];
                board[i][j]='.';

                if(!issafe(board,i,j,ch)){
                    return false;
                }
                board[i][j]=ch;

            }
        }
        return true;
    }
    public boolean issafe(char[][] board,int row,int col,char ch){
        //row check
        for(int j=0;j<board.length;j++){
            if(board[row][j]==ch || board[j][col]==ch){
                return false;
            }
        }

        int nrow=row/3*3;
        int ncol=col/3*3;
        for(int i=nrow;i<nrow+3;i++){
            for(int j=ncol;j<ncol+3;j++){
                if(board[i][j]==ch){
                    return false;
                }
            }
        }
        return true;

    }
}