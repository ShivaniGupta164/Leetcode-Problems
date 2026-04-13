class Solution {
    public int getMinDistance(int[] arr, int target, int start) {
        int n=arr.length;
        int ans=n-1;

        for(int i=0; i<n; i++){
            if(arr[i]==target){
                ans=Math.min(ans,Math.abs(i-start));
                
                
            }
            
        }
        return ans;
        
    }
}