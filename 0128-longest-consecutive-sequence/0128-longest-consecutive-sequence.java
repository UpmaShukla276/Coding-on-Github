class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int longest = 0;
        for(int n:set){
            if(!set.contains(n-1)){
                int count = 1;
                int num=n;

                while(set.contains(num+1)){
                    num++;
                    count++;
                }
                longest = Math.max(longest,count);
            }
            
        }
        return longest;

    }
}