class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquares(n);
        int power = 1, lam = 1;
        while(slow != fast){
            if(power == lam){
                slow = fast;
                power *= 2;
                lam = 0;
            }
            fast = sumOfSquares(fast);
            lam++;
        }
        return fast == 1;
    }

    private int sumOfSquares(int n){
        int res = 0;
        while(n > 0){
            res += Math.pow(n % 10, 2);
            n = n /10;
        }
        return res;
    }
}
