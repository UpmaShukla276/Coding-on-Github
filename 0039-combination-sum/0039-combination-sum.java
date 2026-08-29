class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        findCombinations(candidates, target, current, 0, answer);
        
        return answer;
    }

    private void findCombinations(int[] candidates, int target, List<Integer> current, int i, List<List<Integer>> answer) {

        // Base Case 1: Target ban gaya!
        if (target == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }

        // Base Case 2: Array khatam ho gaya YA target negative ho gaya
        if (i == candidates.length || target < 0) {
            return;
        }

        // Choice 1: Current element ko INCLUDE karo (usi element pe raho — repetition allowed)
        current.add(candidates[i]);
        findCombinations(candidates, target - candidates[i], current, i, answer);

        // Backtrack
        current.remove(current.size() - 1);

        // Choice 2: Current element ko EXCLUDE karo (agle element pe jao)
        findCombinations(candidates, target, current, i + 1, answer);
    }
}