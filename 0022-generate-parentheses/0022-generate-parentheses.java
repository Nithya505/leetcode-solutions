class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        backtrack(res, "", 0, 0, n);

        return res;
    }

    private void backtrack(List<String> res,
                           String curr,
                           int open,
                           int close,
                           int n) {

        // valid parentheses formed
        if(curr.length() == 2 * n) {
            res.add(curr);
            return;
        }

        // add opening bracket
        if(open < n) {
            backtrack(res,
                      curr + "(",
                      open + 1,
                      close,
                      n);
        }

        // add closing bracket
        if(close < open) {
            backtrack(res,
                      curr + ")",
                      open,
                      close + 1,
                      n);
        }
    }
}