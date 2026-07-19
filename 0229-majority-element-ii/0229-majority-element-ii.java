import java.util.*;

class Solution {

    public List<Integer> majorityElement(int[] nums) {

        // Maximum 2 majority elements ho sakte hain (> n/3)
        int candidate1 = 0;
        int candidate2 = 0;

        // Dono candidates ke votes
        int count1 = 0;
        int count2 = 0;

        // =======================
        // First Pass: Possible candidates find karo
        // =======================
        for (int num : nums) {

            // Agar current number candidate1 hai
            // to uske votes badha do
            if (num == candidate1) {
                count1++;
            }

            // Agar current number candidate2 hai
            // to uske votes badha do
            else if (num == candidate2) {
                count2++;
            }

            // Agar candidate1 ke votes khatam ho gaye
            // to current number ko candidate1 bana do
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }

            // Agar candidate2 ke votes khatam ho gaye
            // to current number ko candidate2 bana do
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }

            // Current number dono candidates se different hai
            // aur dono ke votes bhi hain
            // To dono ke votes 1-1 kam kar do (Vote Cancellation)
            else {
                count1--;
                count2--;
            }
        }

        // =======================
        // Second Pass: Actual frequency count karo
        // =======================

        // Purane votes reset karo
        count1 = 0;
        count2 = 0;

        // Candidate1 aur Candidate2 kitni baar aaye hain
        // unki actual frequency count karo
        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            }

            else if (num == candidate2) {
                count2++;
            }
        }

        // Final answer list
        List<Integer> ans = new ArrayList<>();

        // Agar candidate1 ki frequency n/3 se zyada hai
        // to answer me add kar do
        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }

        // Agar candidate2 ki frequency n/3 se zyada hai
        // to answer me add kar do
        if (count2 > nums.length / 3) {
            ans.add(candidate2);
        }

        return ans;
    }
}