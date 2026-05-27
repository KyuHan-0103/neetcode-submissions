class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = (matrix.length * matrix[0].length);
        int mid;
        while(l < r){
            mid = (r + l)/2;
            int row = mid/matrix[0].length;
            int col = mid % matrix[0].length;
            if(matrix[row][col] == target){
                return true;
            } else if (matrix[row][col] < target){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return false;
    }
}
