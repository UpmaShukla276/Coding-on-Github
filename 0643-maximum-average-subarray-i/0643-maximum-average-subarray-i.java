class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        int windowSum = 0;

        //first window
        for(int i=0; i<k;i++){
            windowSum = windowSum + nums[i];
        }
        maxSum = windowSum;

        //Slide the window
        for(int i=k; i<nums.length; i++){
            windowSum = windowSum + nums[i];
            windowSum = windowSum - nums[i-k];

            maxSum = Math.max(maxSum, windowSum);

        }
        return (double) maxSum/k;  //calculates the average so we divide by k
    }
}