class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        findSubsets(nums, current, 0, answer);
        return answer; 
    }
    private void findSubsets(int[] nums, List<Integer> current, int i, List<List<Integer>> answer) {

        // Base Case: saare elements dekh liye
        if (i == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[i]);
        findSubsets(nums, current, i + 1, answer);

        // backtrackk
        current.remove(current.size() - 1);

        int index = i + 1;
        while (index < nums.length && nums[index] == nums[i]) {
            index++;
        }
        findSubsets(nums, current, index, answer);
    }
}