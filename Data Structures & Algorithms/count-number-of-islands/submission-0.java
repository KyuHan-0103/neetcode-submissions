class Solution {

    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int islands = 0;
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == '1'){
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = '0';
        q.add(new int[]{r, c});

        while(!q.isEmpty()){
            int[] coord = q.poll();
            int row = coord[0], col = coord[1];

            if(row + 1 < grid.length && grid[row + 1][col] == '1'){
                q.add(new int[]{row + 1, col});
                grid[row + 1][col] = '0';
            }
            if(row - 1 >= 0 && grid[row - 1][col] == '1'){
                q.add(new int[]{row - 1, col});
                grid[row - 1][col] = '0';
            }
            if(col + 1 < grid[0].length && grid[row][col + 1] == '1'){
                q.add(new int[]{row, col + 1});
                grid[row][col + 1] = '0';
            }
            if(col - 1 >= 0 && grid[row][col - 1] == '1'){
                q.add(new int[]{row, col - 1});
                grid[row][col - 1] = '0';
            }
        }
    }
}
