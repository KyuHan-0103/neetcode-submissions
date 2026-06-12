class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ROW, COL;
    boolean sur;
    public void solve(char[][] board) {
        ROW = board.length;
        COL = board[0].length;

        for(int r = 0; r < ROW; r++){
            for(int c = 0; c < COL; c++){
                if(board[r][c] == 'O'){
                    Deque<int[]> stack = new ArrayDeque<>(Arrays.asList(new int[]{r, c}));
                    sur = false;
                    if(dfs(board, r, c, stack)){
                        while(!stack.isEmpty()){
                            int[] coords = stack.pop();
                            board[coords[0]][coords[1]] = 'O';
                        }
                    }
                }
            }
        }
    }

    private boolean dfs(char[][] board, int r, int c, Deque<int[]> cells){
        if(!sur){
            if(r + 1 >= ROW || r - 1 < 0 || c + 1 >= COL || c - 1 < 0){
                sur = true;
            }
        }
        cells.push(new int[]{r, c});
        board[r][c] = 'X';
        for(int[] d : directions){
            int nr = r + d[0], nc = c + d[1];
            if(nr < 0 || nc < 0 || nr >= board.length ||
            nc >= board[0].length || board[nr][nc] == 'X'){
                continue;
            }
            dfs(board, nr, nc, cells);
        }
        return sur;
    }
}
