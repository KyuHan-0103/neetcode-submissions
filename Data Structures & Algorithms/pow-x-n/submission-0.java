class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double temp = recursive(x, Math.abs(n));
        return (n >= 0) ? temp : 1/temp;
    }

    private double recursive(double x, int n){
        if(n == 1){
            return x;
        }
        double y = recursive(x, n - 1);
        System.out.println(y);
        return x * y;
    }
}
