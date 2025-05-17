class Solution {
    public void sortColors(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i:nums){
            if(i==0)
                a++;
            else if(i==1)
                b++;
            else
                c++;
        }
        int i=0;
        while(a-->0)
            nums[i++] = 0;
        while(b-->0)
            nums[i++] = 1;
        while(c-->0)
            nums[i++] = 2;
        
    }
}