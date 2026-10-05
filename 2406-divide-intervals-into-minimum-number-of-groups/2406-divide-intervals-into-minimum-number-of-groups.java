class Solution {
    public int minGroups(int[][] intervals) {

        int[] changes = new int[1000002];

        for (int i = 0; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            changes[start]++;
            changes[end + 1]--;
        }

        int groups = 0;
        int current = 0;

        for (int i = 0; i < changes.length; i++) {

            current += changes[i];

            groups = Math.max(groups, current);
        }

        return groups;
    }
}