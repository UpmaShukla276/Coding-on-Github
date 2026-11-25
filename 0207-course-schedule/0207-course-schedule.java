
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Step 1: Create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Create indegree array
        int[] indegree = new int[numCourses];

        // Step 3: Build graph
        for (int[] pair : prerequisites) {

            int course = pair[0];
            int prerequisite = pair[1];

            graph.get(prerequisite).add(course);

            indegree[course]++;
        }

        // Step 4: Create queue
        Queue<Integer> queue = new LinkedList<>();

        // Add all nodes having indegree 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 5: BFS
        int count = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            count++;

            // Visit neighbours
            for (int neighbour : graph.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        // Step 6: Check if all courses are completed
        return count == numCourses;
    }
}
