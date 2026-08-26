class Solution {
    static final long MOD = 1000000007;
    public int countGoodNumbers(long n) {

        long evenposn= (n+1)/2;
        long oddposn = n/2;

        long evenWays = power(5,evenposn);
        long oddWays = power(4,oddposn);

        return (int)((evenWays*oddWays)%MOD);
    }

    public long power(long x, long n ){
        long result = 1;

        while(n>0){
            if((n&1)==1){
                result = ((result*x)%MOD);
            }
            x = (x * x) % MOD;

            n = n / 2;
        }
        return result;
    }
}