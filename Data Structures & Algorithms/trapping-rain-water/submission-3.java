class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n==0){
            return 0;
        }
        
        int l = 0, r = n - 1;
        int maxL = height[l], maxR = height[r];
        int total = 0;
        while(l < r){

            if(maxL < maxR){
                l++;
                maxL = Math.max(maxL, height[l]);
                total += (maxL - height[l]);
            } else{
                r--;
                maxR = Math.max(maxR, height[r]);
                total += (maxR - height[r]);
            }
        }
        return total;
    }
}