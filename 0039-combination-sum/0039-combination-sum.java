class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        // Backtracking start kar rahe hain
        backtrack(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    public void backtrack(int index, int[] candidates, int target,
                          List<Integer> current,
                          List<List<Integer>> ans) {

        // Target 0 ho gaya → combination mil gaya
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Target negative ho gaya → ye path possible nahi hai
        if (target < 0) {
            return;
        }

        // Index se aage ke saare numbers try karo
        for (int i = index; i < candidates.length; i++) {

            // Number choose karo
            current.add(candidates[i]);

            // Target se chosen number minus karo
            // i same rakha kyunki same number dobara use ho sakta hai
            backtrack(i, candidates, target - candidates[i],
                      current, ans);

            // Undo: last chosen number remove karo
            current.remove(current.size() - 1);
        }
    }
}