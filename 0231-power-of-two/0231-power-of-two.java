class Solution {
    public boolean isPowerOfTwo(int n) {
        // 1 << i = 2^i
        return n>0 && (n&(n-1))==0;
    }
}