class Solution {
    static final int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int ROW = grid.length, COL = grid[0].length;

        for(int r = 0; r < ROW; r++){
            for(int c = 0; c < COL; c++){
                if(grid[r][c] == 0){
                    q.offer(new int[]{r, c});
                }
            }
        }

        while(!q.isEmpty()){
            int[] coords = q.poll();
            int r = coords[0], c = coords[1];

            for(int[] dir : directions){
                int newR = r + dir[0], newC = c + dir[1];

                if(newR < 0 || newC < 0 || newR >= grid.length
                || newC >= grid[0].length || grid[newR][newC] == -1){
                    continue;
                }
                if(grid[newR][newC] != INF) continue;
                grid[newR][newC] = grid[r][c] + 1;
                q.offer(new int[]{newR, newC});
            }
        }
    }
}
