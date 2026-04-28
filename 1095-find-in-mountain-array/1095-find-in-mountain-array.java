class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // 1️⃣ Find Peak Index
        int peak = findPeak(mountainArr);

        // 2️⃣ Search in Ascending Part (0 → peak)
        int left = binarySearch(mountainArr, 0, peak, target, true);
        if (left != -1) return left;

        // 3️⃣ Search in Descending Part (peak+1 → n-1)
        return binarySearch(mountainArr, peak + 1, n - 1, target, false);
    }

    // 🔹 Find Peak Element (Binary Search)
    private int findPeak(MountainArray mountainArr) {
        int low = 0, high = mountainArr.length() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                low = mid + 1;   // going up
            else
                high = mid;      // going down
        }
        return low; // peak index
    }

    // 🔹 Binary Search (Asc + Desc handled)
    private int binarySearch(MountainArray mountainArr, int low, int high, int target, boolean asc) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = mountainArr.get(mid);

            if (val == target)
                return mid;

            if (asc) {
                // Ascending
                if (val < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                // Descending
                if (val > target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}