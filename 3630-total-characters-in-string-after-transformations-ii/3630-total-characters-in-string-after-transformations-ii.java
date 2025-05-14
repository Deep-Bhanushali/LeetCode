import java.util.List;

class Solution {
    private static final int MOD = 1000000007;
    private static final int ALPHA = 26;

    private long[][] multiply(long[][] A, long[][] B) {
        long[][] result = new long[ALPHA][ALPHA];
        for (int i = 0; i < ALPHA; i++) {
            for (int j = 0; j < ALPHA; j++) {
                for (int k = 0; k < ALPHA; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return result;
    }

    private long[][] pow(long[][] matrix, long t) {
        long[][] result = new long[ALPHA][ALPHA];
        for (int i = 0; i < ALPHA; i++) {
            result[i][i] = 1; // Identity matrix
        }
        while (t > 0) {
            if ((t & 1) == 1) {
                result = multiply(result, matrix);
            }
            matrix = multiply(matrix, matrix);
            t >>= 1;
        }
        return result;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] numsArray = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            numsArray[i] = nums.get(i);
        }

        long[] cnt = new long[ALPHA];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        long[][] transition = new long[ALPHA][ALPHA];
        for (int i = 0; i < ALPHA; i++) {
            for (int j = 1; j <= numsArray[i]; j++) {
                int nextChar = (i + j) % ALPHA;
                transition[nextChar][i] = 1; // Character i contributes to nextChar
            }
        }

        transition = pow(transition, t);

        long[] finalCnt = new long[ALPHA];
        for (int i = 0; i < ALPHA; i++) {
            for (int j = 0; j < ALPHA; j++) {
                finalCnt[i] = (finalCnt[i] + transition[i][j] * cnt[j]) % MOD;
            }
        }

        long result = 0;
        for (long val : finalCnt) {
            result = (result + val) % MOD;
        }
        return (int) result;
    }
}