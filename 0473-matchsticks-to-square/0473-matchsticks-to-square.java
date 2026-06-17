class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int sum = 0;
        for (int x : matchsticks) sum += x;
        if (sum % 4 != 0)
            return false;
        int side = sum / 4;
        Arrays.sort(matchsticks);
        for (int i = 0; i < n / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[n - 1 - i];
            matchsticks[n - 1 - i] = temp;
        }
        int[] sides = new int[4];
        return backtrack(0, matchsticks, sides, side);
    }

    private boolean backtrack(int idx, int[] matchsticks, int[] sides, int side) {
        if (idx == matchsticks.length) {
            return sides[0] == side && sides[1] == side && sides[2] == side && sides[3] == side;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[idx] <= side) {
                sides[i] += matchsticks[idx];
                if (backtrack(idx + 1, matchsticks, sides, side))
                return true;
                sides[i] -= matchsticks[idx];
            }
        }
        return false;
    }
}

