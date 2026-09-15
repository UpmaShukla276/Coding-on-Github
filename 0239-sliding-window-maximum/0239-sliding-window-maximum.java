import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length - k + 1;

        int[] ans = new int[n];

        Deque<Integer> dq = new ArrayDeque<>();

        int index = 0;

        for(int i = 0; i < nums.length; i++) {

            // Remove elements which are outside the window
            if(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.addLast(i);

            // Start storing answers once window size becomes k
            if(i >= k - 1) {
                ans[index] = nums[dq.peekFirst()];
                index++;
            }
        }

        return ans;
    }
}