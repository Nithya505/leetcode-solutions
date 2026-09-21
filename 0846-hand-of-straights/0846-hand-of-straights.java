import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        // Total cards must be divisible by groupSize
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Store card -> frequency
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // Continue until all cards are used
        while (!map.isEmpty()) {

            // Smallest available card must start a group
            int first = map.firstKey();

            // Form a group: first, first+1, ..., first+groupSize-1
            for (int i = 0; i < groupSize; i++) {

                int card = first + i;

                // Required consecutive card doesn't exist
                if (!map.containsKey(card)) {
                    return false;
                }

                // Use one occurrence
                int count = map.get(card);

                if (count == 1) {
                    map.remove(card);
                } else {
                    map.put(card, count - 1);
                }
            }
        }

        return true;
    }
}