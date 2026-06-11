class Solution {
    int max;
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        max = 0;

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == 1){
                    bfs(grid, r, c);
                }
            }
        }
        return max;
    }

    private void bfs(int[][] grid, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = 0;
        int m = 0;
        q.add(new int[]{r , c});

        while(!q.isEmpty()){
            int[] coords = q.poll();
            int row = coords[0], col = coords[1];
            m++;
            max = Math.max(max, m);

            if(row + 1 < grid.length && grid[row + 1][col] == 1){
                q.add(new int[]{row + 1, col});
                grid[row + 1][col] = 0;
            }
            if(row - 1 >= 0 && grid[row - 1][col] == 1){
                q.add(new int[]{row - 1, col});
                grid[row - 1][col] = 0;
            }
            if(col + 1 < grid[0].length && grid[row][col + 1] == 1){
                q.add(new int[]{row, col + 1});
                grid[row][col + 1] = 0;
            }
            if(col - 1 >= 0 && grid[row][col - 1] == 1){
                q.add(new int[]{row, col - 1});
                grid[row][col - 1] = 0;
            }
        }

    }
}
