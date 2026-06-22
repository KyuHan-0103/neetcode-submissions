class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int[][] indegree = new int[ROWS][COLS];
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};   

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                for(int[] d : directions){
                    int nr = r + d[0], nc = c + d[1];
                    if(nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS
                    && matrix[nr][nc] < matrix[r][c]){
                        indegree[r][c]++;
                    }
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(indegree[r][c] == 0){
                    q.offer(new int[]{r, c});
                }
            }
        } 

        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                for(int[] d : directions){
                    int nr = r + d[0], nc = c + d[1];
                    if(nr >= 0 && nc >= 0 && nr < ROWS &&
                    nc < COLS && matrix[nr][nc] > matrix[r][c]){
                        indegree[nr][nc]--;
                        if(indegree[nr][nc] == 0){
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            res++;
        }
        return res;
    }
}
