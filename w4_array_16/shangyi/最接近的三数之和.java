class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int count = nums.length;
        int m, n, p = 0; 
        int s = 10000; 
        for(int i=0;i<count-2;i=i+1){
            for(int j=i+1;j<count-1;j=j+1){
                for(int k=j+1;k<count;k=k+1){
                    n = nums[i] + nums[j] + nums[k];
                    m = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    if (m <= s) {
                        s = m;
                        p = n;
                    }
                }
            }
        }
        
        return p;
    }
}