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
        int res = 0;
        int l = 0, r = max;
        while(l < r){
            int timeToEat = 0;
            for(int i = 0; i < piles.length; i++){
                timeToEat += (int) Math.ceil((double) piles[i]/mid);
            }
            if(timeToEat <= h){
                System.out.println(mid);
                r = mid;
                res = mid;
                mid = (l + r)/2;
            } else if (timeToEat > h){
                l = mid + 1;
                mid = (l+r)/2;
            }

        }
        return res;

    }
}
