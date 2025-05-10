class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int l = 0, r = 0, prod = 1;
        int res = 0;

        for(r = 0; r < nums.length; r++){
            prod *= nums[r];

            while(prod >= k){
                prod /= nums[l];
                l++;
            }
            res += r-l+1;
        }
        return res;

    }
}