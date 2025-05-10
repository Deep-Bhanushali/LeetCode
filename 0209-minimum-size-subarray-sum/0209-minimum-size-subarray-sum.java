class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int l = 0, r = 0, cs=0;
        int res = Integer.MAX_VALUE;
        for(r = 0; r < nums.length; r++){
            cs+=nums[r];
            while(cs>=k){
                res = Math.min(res,r-l+1);
                cs-=nums[l++];
            }
        }
        return (res == Integer.MAX_VALUE) ? 0:res;
    }
}