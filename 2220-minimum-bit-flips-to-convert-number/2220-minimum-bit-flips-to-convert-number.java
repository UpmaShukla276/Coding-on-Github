class Solution {
    public int minBitFlips(int start, int goal) {
        int x = start^goal;

        int count = Integer.bitCount(x);
        return count;
        
    }
}