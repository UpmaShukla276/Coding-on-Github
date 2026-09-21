class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int count = 0;
        // loopingg
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                if (count > 0) ans += c;
                count++;
            } else {
                count--;
                if (count > 0) ans += c;
            }
        }
        return ans;
    }
}
