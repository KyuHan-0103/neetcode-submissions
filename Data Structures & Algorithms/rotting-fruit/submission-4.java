class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int max = 0;
        int ROW = grid.length, COL = grid[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int r = 0; r < ROW; r++){
            for(int c = 0; c < COL; c++){
                if(grid[r][c] == 2){
                    q.offer(new int[]{r, c});
                    max = -1;
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];
                for(int[] d : directions){
                    int nr = r + d[0], nc = c + d[1];
                    if(nr < 0 || nc < 0 || nr >= grid.length
                    || nc >= grid[0].length || grid[nr][nc] != 1) continue;

                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                }
            }
            max++;
        }

        for(int r = 0; r < ROW; r++){
            for(int c = 0; c < COL; c++){
                if(grid[r][c] == 1) return -1;
            }
        }

        return max;
    }
}
