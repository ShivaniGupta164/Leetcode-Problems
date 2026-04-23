class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Step 1: Store indices
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: Process each group
        for (ArrayList<Integer> list : map.values()) {
            int size = list.size();

            long[] prefix = new long[size];
            prefix[0] = list.get(0);

            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            for (int i = 0; i < size; i++) {
                long currIndex = list.get(i);

                long left = (long)i * currIndex - (i > 0 ? prefix[i - 1] : 0);
                long right = (prefix[size - 1] - prefix[i]) - (long)(size - i - 1) * currIndex;

                res[list.get(i)] = left + right;
            }
        }

        return res;
    }
}