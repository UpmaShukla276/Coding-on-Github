class Solution {
    public void moveZeroes(int[] nums) {

        int n = nums.length;

        int[] temp = new int[n];

        int index = 0;

        // Store all non-zero elements
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp[index] = nums[i];
                index++;
            }
        }

        // Copy back to original array
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}