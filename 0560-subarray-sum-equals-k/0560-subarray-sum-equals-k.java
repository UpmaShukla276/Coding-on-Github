import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {

        // HashMap banaya jisme:
        // Key   = Prefix Sum (ab tak ka total sum)
        // Value = Ye prefix sum kitni baar aaya hai
        HashMap<Integer, Integer> map = new HashMap<>();

        // Starting me prefix sum 0 ek baar mana jata hai.
        // Ye un subarrays ke liye zaroori hai jo index 0 se start hote hain.
        map.put(0, 1);

        // currSum = Running Sum / Prefix Sum
        int currSum = 0;

        // Final answer
        int count = 0;

        // Array ke har element par iterate karo
        for (int num : nums) {

            // Current element ko running sum me add karo
            currSum += num;

            /*
             Formula:
             Subarray Sum = Current Prefix Sum - Previous Prefix Sum

             Hume Subarray Sum = k chahiye.

             Isliye,

             k = currSum - previousPrefix

             => previousPrefix = currSum - k

             Agar (currSum - k) pehle kabhi aa chuka hai,
             to uska matlab current index par end hone wala
             ek ya ek se zyada valid subarray mil gaya.
            */
            if (map.containsKey(currSum - k)) {

                // Agar same prefix sum multiple baar aaya hai,
                // to utne hi valid subarrays honge.
                count += map.get(currSum - k);
            }

            /*
             Ab current prefix sum ko HashMap me store karo.

             Agar pehle se present hai to frequency +1 kar do,
             warna pehli baar hai to frequency = 1.
            */
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        // Total valid subarrays return karo
        return count;
    }
}