class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find sbse bda pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            long hours = 0;

            // Calculate total hours needed at speed = mid
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                // Can finish, try smaller speed
                right = mid;
            } else {
                // Too slow
                left = mid + 1;
            }
        }

        return left;
    }
}