import java.util.*;

class Solution {
    // Calculate hamming distance between two strings
    private int hammingDistance(String s1, String s2) {
        if (s1.length() != s2.length()) return Integer.MAX_VALUE;
        int distance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
    
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        // dp[i] stores the length of longest valid subsequence ending at index i
        int[] dp = new int[n];
        // prev[i] stores the previous index in the longest subsequence ending at i
        int[] prev = new int[n];
        // Initialize arrays
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        
        // Track max length and ending index
        int maxLen = 1;
        int maxEnd = 0;
        
        // For each index
        for (int i = 1; i < n; i++) {
            // Check all previous indices
            for (int j = 0; j < i; j++) {
                // Check if groups are different and hamming distance is 1
                if (groups[i] != groups[j] && 
                    hammingDistance(words[i], words[j]) == 1) {
                    // Update dp if we found a longer subsequence
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            // Update max length and ending index if current is longer
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxEnd = i;
            }
        }
        
        // Reconstruct the subsequence
        List<String> result = new ArrayList<>();
        while (maxEnd != -1) {
            result.add(words[maxEnd]);
            maxEnd = prev[maxEnd];
        }
        
        // Reverse to get correct order
        Collections.reverse(result);
        return result; // Return the List<String> directly
    }
}