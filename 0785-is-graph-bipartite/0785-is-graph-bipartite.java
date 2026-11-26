
class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        // -1 means not visited
        // 0 and 1 represent two different colors
        int[] color = new int[n];

        Arrays.fill(color, -1);

        // Check every node because graph can be disconnected
        for (int i = 0; i < n; i++) {

            // If already colored, skip it
            if (color[i] != -1) {
                continue;
            }

            Queue<Integer> q = new LinkedList<>();

            // Give starting node color 0
            color[i] = 0;

            q.add(i);

            while (!q.isEmpty()) {

                int node = q.poll();

                // Visit all neighbors
                for (int neighbor : graph[node]) {

                    // If neighbor is not colored
                    if (color[neighbor] == -1) {

                        // Give opposite color
                        color[neighbor] = 1 - color[node];

                        q.add(neighbor);
                    }

                    // If both have same color
                    else if (color[neighbor] == color[node]) {

                        return false;
                    }
                }
            }
        }

        return true;
    }
}
