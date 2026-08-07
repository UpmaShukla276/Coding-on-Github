class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        // if required > avaabibaleleeee
        if ((long) m * k > bloomDay.length) {
            return -1;
            
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find minimum and maximum bloom dayyy
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        // now binary search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // checking in "mid day" if it matches no. of bouquets
            if (canMake(bloomDay, mid, m, k)) {

                // earlier days try
                high = mid - 1;

            } else {

                // need more days
                low = mid + 1;
            }
        }

        // minimum possible day
        return low;
    }

    private boolean canMake(int[] bloomDay, int day, int m, int k) {

        // Number of bouquets made so far
        int bouquets = 0;

        // Number of adjacent flowers collected
        int flowers = 0;

        // Traverse every flower
        for (int bloom : bloomDay) {

            // Check if flower has bloomed by day
            if (bloom <= day) {

                // flower is available
                flowers++;

                // if enough adjacent flowers are collected
                if (flowers == k) {

                    // make eklauta bouquet
                    bouquets++;

                    // flowers are used, start counting again
                    flowers = 0;
                }

            } else {

                // flower not bloomed
                // adjacency break hogyi toh
                flowers = 0;
            }
        }

        // ifff we made at least m bouquets
        return bouquets >= m;
    }
}