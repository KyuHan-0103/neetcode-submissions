class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        int ROW = board.length, COL = board[0].length;
        //Iterate through all the top and bottom borders
        for(int c = 0; c < COL; c++){
            if(board[0][c] == 'O') dfs(board, 0, c);
            if(board[ROW - 1][c] == 'O') dfs(board, ROW - 1, c);
        }

        for(int r = 1; r < ROW - 1; r++){
            if(board[r][0] == 'O') dfs(board, r, 0);
            if(board[r][COL - 1] == 'O') dfs(board, r, COL - 1);
        }

        for(int r = 0; r < ROW; r++){
            for(int c = 0; c < COL; c++){
                if(board[r][c] == 'T'){
                    board[r][c] = 'O';
                } else {
                    board[r][c] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, int r, int c){
        board[r][c] = 'T';
        for(int[] d : directions){
            int nr = r + d[0], nc = c + d[1];
            if(nr < 0 || nc < 0 || nr >= board.length ||
            nc >= board[0].length || board[nr][nc] != 'O') continue;

            dfs(board, nr, nc);
        }
    }
}
