class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        findCombinations(k, n, current, 1, answer);   // 1 se start karo

        return answer;
    }

    private void findCombinations(int k, int n, List<Integer> current, int num, List<List<Integer>> answer) {

        // Base Case 1: Success!
        if (current.size() == k && n == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }

        // Base Case 2: Dead ends
        if (current.size() == k || n < 0 || num > 9) {
            return;
        }

        // Choice 1: INCLUDE
        current.add(num);
        findCombinations(k, n - num, current, num + 1, answer);

        // Backtrack
        current.remove(current.size() - 1);

        // Choice 2: EXCLUDE
        findCombinations(k, n, current, num + 1, answer);
    }
}