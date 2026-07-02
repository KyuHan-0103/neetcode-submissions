class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = numBits(n);
            n--;
        }
        return res;
    }
    private int numBits(int n){
        int res = 0;
        while(n != 0){
            res += (n & 1) == 1 ? 1 : 0;
            n >>= 1;
        }
        return res;
    }
}
