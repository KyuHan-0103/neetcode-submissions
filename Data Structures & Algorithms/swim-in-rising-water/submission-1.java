class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int ROW = grid.length, COL = grid[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.add(new int[]{grid[0][0], 0, 0});
        int t = -1;
        boolean[][] visit = new boolean[ROW][COL];
        while(!visit[ROW - 1][COL - 1]){
            t++;
            while(q.peek()[0] <= t){
                int[] cur = q.poll();
                visit[cur[1]][cur[2]] = true;
                for(int[] dir : directions){
                    int nr = cur[1] + dir[0], nc = cur[2] + dir[1];
                    if(nr < 0 || nc < 0 || nr >= ROW ||
                    nc >= COL || visit[nr][nc]) continue;
                    q.add(new int[]{grid[nr][nc], nr, nc});
                }
                if(visit[ROW-1][COL-1])break;
            }
        }

        return t;
    }
}
