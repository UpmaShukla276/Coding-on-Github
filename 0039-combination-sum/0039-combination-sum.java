class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    public void backtrack(int index, int[] candidates, int target,
                          List<Integer> current,
                          List<List<Integer>> ans) {

        // BASE CASE
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // CHOICES
        for (int i = index; i < candidates.length; i++) {

            // Constraint: target negative nahi hona chahiye
            if (target - candidates[i] < 0) {
                continue;
            }

            // MAKE CHOICE
            current.add(candidates[i]);

            // BACKTRACK / Explore
            backtrack(i, candidates, target - candidates[i],
                      current, ans);

            // UNDO CHOICE
            current.remove(current.size() - 1);
        }
    }
}