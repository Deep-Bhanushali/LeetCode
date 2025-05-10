class Solution {
    public double findMaxAverage(int[] arr, int k) {
        if(arr.length < k){
            return -1;
        }
        int i = 0,j=0,sum=0;
        double maxAvg = Double.NEGATIVE_INFINITY;
        while(j<arr.length){
            sum+=arr[j];
            if(j-i+1<k){
                j++;
            }else if(j-i+1 == k){
                maxAvg = Math.max((double)sum/k,maxAvg);
                sum-=arr[i];
                j++;
                i++;
            }
        }
        return maxAvg;
    }
}