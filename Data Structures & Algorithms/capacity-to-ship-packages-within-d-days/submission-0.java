class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for(int n : weights){
            l = Math.max(l, n);
            r += n;
        }
        int res = r;;
        int cap;
        while(l <= r){
            cap = (l + r)/2;
            if(canShip(weights, days, cap)){
                res = Math.min(res, cap);
                r = cap - 1;
            } else {
                l = cap + 1;
            }
        }
        return res;
    }

    private boolean canShip(int[] weights, int days, int cap){
        int ship = 1, curCap = cap;
        for(int n : weights){
            if(curCap - n < 0){
                ship++;
                if(ship > days) return false;
                curCap = cap;
            }
            curCap -= n;
        }
        return true;
    }
}