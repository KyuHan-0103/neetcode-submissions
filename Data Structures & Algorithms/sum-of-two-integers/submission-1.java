class Solution {
    public int getSum(int a, int b) {
        while(a != 0){
            int ta = a, tb = b;
            int temp = a & b;
            temp <<= 1;
            b = ta ^ tb;
            a = temp;
        }
        return b;
    }
}
