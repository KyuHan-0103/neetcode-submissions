class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n==0){
            return 0;
        }
        int[] leftM = new int[n];
        int[] rightM = new int[n];
        leftM[0] = height[0];
        rightM[n - 1] = height[n - 1];
        int total = 0;
        for(int i = 1, j = n-2; i < n && j>=0; i++, j--){
            leftM[i] = Math.max(leftM[i-1], height[i]);
            rightM[j] = Math.max(rightM[j + 1], height[j]);
        }
        for(int i = 1; i < n - 1; i++){
            total += (Math.min(leftM[i], rightM[i]) - height[i]);
        }
        return total;
    }
}