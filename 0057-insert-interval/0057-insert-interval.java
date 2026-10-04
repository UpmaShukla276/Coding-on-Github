class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // Current interval is completely BEFORE newInterval
            if (currentEnd < newInterval[0]) {
                list.add(intervals[i]);
            }

            // Current interval is completely AFTER newInterval
            else if (currentStart > newInterval[1]) {

                // First add newInterval
                list.add(newInterval);

                // Then add current interval
                list.add(intervals[i]);

                // Add all remaining intervals
                for (int j = i + 1; j < intervals.length; j++) {
                    list.add(intervals[j]);
                }

                return list.toArray(new int[list.size()][]);
            }

            // Current interval overlaps with newInterval
            else {
                newInterval[0] = Math.min(newInterval[0], currentStart);
                newInterval[1] = Math.max(newInterval[1], currentEnd);
            }
        }

        // If newInterval was not added yet
        list.add(newInterval);

        return list.toArray(new int[list.size()][]);
    }
}

