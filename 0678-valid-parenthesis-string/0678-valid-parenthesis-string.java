class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> extraopenbrackets = new Stack<>();
        Stack<Integer> aestrick = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                extraopenbrackets.push(i);
            } else if (ch == '*') {
                aestrick.push(i);
            } else {
                if (!extraopenbrackets.isEmpty()) {
                    extraopenbrackets.pop();
                } else if (!aestrick.isEmpty()) {
                    aestrick.pop();
                } else {
                    return false;
                }
            }
        }
        while (!extraopenbrackets.isEmpty()) {
            if (aestrick.isEmpty()) {
                return false;
            }
            int openindex = extraopenbrackets.pop();
            int closeindex = aestrick.pop();
            if (openindex > closeindex) {
                return false;
            }
        }
        return extraopenbrackets.isEmpty();
    }
}
