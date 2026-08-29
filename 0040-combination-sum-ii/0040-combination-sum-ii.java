class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);   // duplicates ko ek saath laane ke liye

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

        // Choice 1: Current element ko INCLUDE karo
        current.add(candidates[i]);
        findCombinations(candidates, target - candidates[i], current, i + 1, answer);
        //                                                                    ↑
        //                                          "i+1" — repetition allowed nahi!

        // Backtrack
        current.remove(current.size() - 1);

        // Choice 2: Current element ko EXCLUDE karo — saare SAME VALUE walon ko bhi skip karo
        int index = i + 1;
        while (index < candidates.length && candidates[index] == candidates[i]) {
            index++;
        }
        findCombinations(candidates, target, current, index, answer);
    }
}