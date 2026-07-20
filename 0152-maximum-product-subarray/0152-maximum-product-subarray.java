class Solution {
    public int maxProduct(int[] nums) {

        // Current maximum product ending at current index
        int maxProduct = nums[0];

        // Current minimum product ending at current index
        int minProduct = nums[0];

        // Final answer
        int answer = nums[0];

        // Traverse from second element
        for (int i = 1; i < nums.length; i++) {

            int curr = nums[i];

            // Purane values save kar lo
            int prevMax = maxProduct;
            int prevMin = minProduct;

            // Current maximum ke 3 possibilities
            maxProduct = Math.max(
                    curr,
                    Math.max(prevMax * curr, prevMin * curr)
            );

            // Current minimum ke 3 possibilities
            minProduct = Math.min(
                    curr,
                    Math.min(prevMax * curr, prevMin * curr)
            );

            // Global answer update karo
            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}