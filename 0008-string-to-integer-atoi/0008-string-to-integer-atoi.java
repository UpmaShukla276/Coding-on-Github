class Solution {
    public int myAtoi(String s) {

        int i = 0;              // Current position in the string
        int n = s.length();     // Length of the string

        // ------------------------------------------------
        // STEP 1: Remove leading spaces
        // ------------------------------------------------
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // ------------------------------------------------
        // STEP 2: Check whether the number is +ve or -ve
        // ------------------------------------------------
        int sign = 1;           // By default, number is positive

        if (i < n && s.charAt(i) == '-') {
            sign = -1;          // Number is negative
            i++;                 // Move to the next character
        }
        else if (i < n && s.charAt(i) == '+') {
            sign = 1;           // Number is positive
            i++;                 // Move to the next character
        }

        // ------------------------------------------------
        // STEP 3: Build the number digit by digit
        // ------------------------------------------------
        int num = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            // Convert character into an integer
            // Example: '5' - '0' = 5
            int digit = s.charAt(i) - '0';

            // ------------------------------------------------
            // STEP 4: Check for integer overflow
            // ------------------------------------------------
            if (num > Integer.MAX_VALUE / 10 ||
                (num == Integer.MAX_VALUE / 10 && digit > 7)) {

                // If positive, return maximum int value
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                }

                // If negative, return minimum int value
                else {
                    return Integer.MIN_VALUE;
                }
            }

            // Add the new digit to our number
            //
            // Example:
            // num = 41
            // digit = 9
            //
            // num = 41 * 10 + 9
            //     = 419
            num = num * 10 + digit;

            // Move to the next character
            i++;
        }

        // ------------------------------------------------
        // STEP 5: Apply the sign
        // ------------------------------------------------
        return num * sign;
    }
}