class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
            for(int i : piles){
                max = Math.max(max, i);
            }
        if(piles.length==h){
            return max;
        }

        int mid = max/2;
        int l = 1, r = max;
        while(l < r){
            mid = (l+r)/2;
            int timeToEat = 0;
            for(int i = 0; i < piles.length; i++){
                timeToEat +=  (piles[i] + mid - 1)/mid;
            }
            if(timeToEat <= h){
                r = mid;
            } else {
                l = mid + 1;
            }

        }
        return l;

    }
}