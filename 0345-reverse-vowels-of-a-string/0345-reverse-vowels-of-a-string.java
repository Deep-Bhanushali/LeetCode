class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int left = 0,right = s.length()-1;
        String vowels = "aeiouAEIOU";
        while(left < right){
            while(left < right && vowels.indexOf(c[left]) == -1){
                left++;
            }
            while(left < right && vowels.indexOf(c[right]) == -1){
                right--;
            }
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
        return new String(c);
    }
}