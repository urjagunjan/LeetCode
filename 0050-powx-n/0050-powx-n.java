class Solution {
    public double myPow(double x, int n) {
        long N = n;  // Use long to avoid overflow

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return rec(x, N);
    }

    private double rec(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        double half = rec(x, n / 2);  

        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}
