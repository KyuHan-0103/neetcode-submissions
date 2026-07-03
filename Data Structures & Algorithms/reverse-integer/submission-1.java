class Solution {
    public int reverse(int x) {
        long res = 0;
        while(x != 0){
            int digit = x % 10;
            x /= 10;
            res = (res * 10) + digit;
            System.out.print(res);
            if(res < -(1 << 31) || res > (1 << 31) - 1) return 0;
        }

        return (int)res;
    }
}
