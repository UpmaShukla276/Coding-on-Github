import java.util.*;

class Solution {

    public int[][] merge(int[][] intervals) {

        // Step 1: Sabse pehle intervals ko unke starting point ke basis par sort kar do.
        // Isse overlapping intervals ek dusre ke paas aa jayenge.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Final merged intervals store karne ke liye list
        List<int[]> ans = new ArrayList<>();

        // Pehla interval hamesha answer me add kar do,
        // kyunki compare karne ke liye kuch to hona chahiye.
        ans.add(intervals[0]);

        // Ab second interval se traversal start karo
        for (int i = 1; i < intervals.length; i++) {

            // Answer list ka last merged interval nikalo
            // Isi se current interval ko compare karenge
            int[] last = ans.get(ans.size() - 1);

            // Agar current interval ka start,
            // last merged interval ke end se chhota ya equal hai,
            // to dono overlap karte hain.
            if (intervals[i][0] <= last[1]) {

                // Overlap hone par start same rahega.
                // Sirf end ko maximum value se update karna hai.
                last[1] = Math.max(last[1], intervals[i][1]);

            } else {

                // Agar overlap nahi hua,
                // to current interval ko alag interval ki tarah answer me add kar do.
                ans.add(intervals[i]);
            }
        }

        // List ko 2D array me convert karke return kar do
        return ans.toArray(new int[ans.size()][]);
    }
}