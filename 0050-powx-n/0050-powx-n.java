class Solution {
    public double myPow(double x, int n) {
        long N = n;

        if (N < 0) {
            N = -N;
        }

        double ans = 1.0;

        while (N > 0) {
            if ((N & 1) == 1) {
                ans = ans * x;
            }

            x = x * x;
            N = N >> 1;
        }

        if (n < 0) {
            return 1 / ans;
        }

        return ans;
    }
}