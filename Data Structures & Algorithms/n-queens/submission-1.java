class Solution {
    int rowLength;
    int colLength;
    List<boolean[][]> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        rowLength = n;
        colLength = n;
        backTrack(n, 0, 0, new boolean[n][n]);
        List<List<String>> result = new ArrayList<>();
        for (boolean[][] board : res) {
            List<String> boardStrings = new ArrayList<>();
            for (boolean[] row : board) {
                StringBuilder sb = new StringBuilder();
                for (boolean cell : row) {
                    sb.append(cell ? 'Q' : '.');
                }
                boardStrings.add(sb.toString());
            }
            result.add(boardStrings);
        }
        return result;
    }

    private void backTrack(int n, int r, int c, boolean[][] board){
        if(r >= rowLength){
            if(n == 0){
             res.add(Arrays.stream(board).map(boolean[]::clone).toArray(boolean[][]::new));
            }
            return;
        }

        if(rowCheck(r, board) && colCheck(c, board) && diagCheck(r, c, board) && antiDiagCheck(r, c, board)){
            board[r][c] = true;
            /*if(c + 1 < colLength){
                backTrack(n - 1, r, c + 1, board);
            } else {
                backTrack(n - 1, r + 1, 0, board);
            }*/
            backTrack(n - 1, r + 1, 0, board);
            board[r][c] = false;
        }
        if(c + 1 < colLength){
            backTrack(n, r, c + 1, board);
        } else {
            backTrack(n, r + 1, 0, board);
        }

        
        
    }

    private boolean rowCheck(int r, boolean[][] board){
        for(int i = 0; i < board[r].length; i++){
            if(board[r][i]){
                return false;
            }
        }
        return true;
    }

    private boolean colCheck(int c, boolean[][] board){
        for(int i = 0; i < board.length; i++){
            if(board[i][c]){
                return false;
            }
        }
        return true;
    }

    private boolean diagCheck(int r, int c, boolean[][] board){
        int row = r;
        int col = c;
        while(row > 0 && col > 0){
            row--;
            col--;
            if(board[row][col]){
                return false;
            }
        }
        while(r < rowLength && c < colLength){
            if(board[r][c]){
                return false;
            }
            r++;
            c++;
        }
        return true;
    }

    private boolean antiDiagCheck(int r, int c, boolean[][]board){
        int row = r;
        int col = c;
        while(row >= 0 && col < colLength){
            if(board[row][col]){
                return false;
            }
            row--;
            col++;
        }
        while(r < rowLength && c >= 0){
            if(board[r][c]){
                return false;
            }
            r++;
            c--;
        }
        return true;
    }
}
