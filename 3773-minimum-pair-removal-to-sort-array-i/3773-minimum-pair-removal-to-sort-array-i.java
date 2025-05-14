class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }

        int op = 0;

        while (!isAccSorted(list)) {
            int minSum = Integer.MAX_VALUE;
            int idx = -1;

            // ✅ Find the adjacent pair with the minimum sum (unconditionally)
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }

            // Replace that pair with their sum
            if (idx != -1) {
                int sum = list.get(idx) + list.get(idx + 1);
                list.remove(idx + 1);
                list.set(idx, sum);
                op++;
            }
        }

        return op;
    }

    public static boolean isAccSorted(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
