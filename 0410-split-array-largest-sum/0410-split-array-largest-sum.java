class Solution {
    public int splitArray(int[] nums, int k) {

        int left = 0;
        int right = 0;

        // left = largest element
        // right = total sum
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {

            // Candidate answer
            int mid = left + (right - left) / 2;

            // Number of subarrays formed
            int pieces = 1;

            // Current subarray sum
            int sum = 0;

            for (int num : nums) {

                // If adding this number exceeds mid,
                // start a new subarray
                if (sum + num > mid) {
                    pieces++;
                    sum = num;
                } else {
                    // Continue current subarray
                    sum += num;
                }
            }

            // If we can split into k or fewer parts,
            // mid is a valid answer
            if (pieces <= k) {
                right = mid;
            } else {
                // Too many parts needed,
                // increase allowed maximum sum
                left = mid + 1;
            }
        }

        return left;
    }
}