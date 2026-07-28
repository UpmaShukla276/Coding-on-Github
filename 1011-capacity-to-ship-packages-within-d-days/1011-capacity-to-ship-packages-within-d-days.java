class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0, high = 0;

        // Find search range
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            int load = 0;
            int d = 1;

            // Check if capacity = mid works
            for (int w : weights) {
                if (load + w > mid) {
                    d++;
                    load = 0;
                }
                load += w;
            }

            if (d <= days)
                high = mid;      // Try kro smaller capacity
            else
                low = mid + 1;   // Need ker leeee beti larger capacity
        }

        return low;
    }
}