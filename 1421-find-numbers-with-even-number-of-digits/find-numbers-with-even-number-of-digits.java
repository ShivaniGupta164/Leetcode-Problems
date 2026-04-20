class Solution {
    public static int countOfDigit(int nums[], int i){
        int cnt=0;
        while(nums[i]>0){
            cnt++;
            nums[i]=nums[i]/10;
        }
        return cnt;
    }
    public int findNumbers(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0; i<n; i++){
            int k=countOfDigit(nums, i);
            if(nums[i]%2==0 && k%2==0)count++;
        }
        return count;
        
    }
}