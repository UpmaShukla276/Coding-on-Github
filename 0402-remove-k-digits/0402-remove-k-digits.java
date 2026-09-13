class Solution {
    public String removeKdigits(String num, int k) {

        StringBuilder s = new StringBuilder();

        // Go through every digit
        for (int i = 0; i < num.length(); i++) {

            char digit = num.charAt(i);

            // Remove bigger previous digits
            while (k > 0 && s.length() > 0 &&
                   s.charAt(s.length() - 1) > digit) {

                s.deleteCharAt(s.length() - 1);
                k--;
            }

            // Add current digit
            s.append(digit);
        }

        // If we still have digits to remove,
        // remove them from the end
        while (k > 0) {
            s.deleteCharAt(s.length() - 1);
            k--;
        }

        // Remove leading zeros
        int i = 0;

        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }

        // If nothing is left
        if (i == s.length()) {
            return "0";
        }

        return s.substring(i);
    }
}