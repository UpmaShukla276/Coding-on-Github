import java.util.*;

class Solution {

    public int[][] merge(int[][] intervals) {

        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);

    
        for (int i = 1; i < intervals.length; i++) {

            // Answer list ka last merged interval nikalo
            // Isi se current interval ko compare karenge
            int[] last = ans.get(ans.size() - 1);

            
            if (intervals[i][0] <= last[1]) {

                // Overlap hone par start same rahega.
                // Sirf end ko maximum value se update karna hai.
                last[1] = Math.max(last[1], intervals[i][1]);

            } else {
                ans.add(intervals[i]);
            }
        }

        // List ko 2D array me convert karke return kar do
        return ans.toArray(new int[ans.size()][]);
    }
}