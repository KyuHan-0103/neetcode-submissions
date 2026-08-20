public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //Rotate top and bottom
        for(int i = 0; i < n/2; i++){
            int bot = n - i - 1;
            for(int j = 0; j < n; j++){
                int temp = matrix[bot][j];
                matrix[bot][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        //Rotate Diagonally
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}