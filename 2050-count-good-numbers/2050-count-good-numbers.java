class Solution {
    static final int MOD = 1_000_000_007;

    // Function to compute (base^exp) % mod using modular exponentiation
    private long modExp(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2; // Since index 0 is even, odd positions are fewer in odd n
        long oddCount = n / 2;
        
        long evenChoices = modExp(5, evenCount, MOD);
        long oddChoices = modExp(4, oddCount, MOD);
        
        return (int) ((evenChoices * oddChoices) % MOD);
    }
}