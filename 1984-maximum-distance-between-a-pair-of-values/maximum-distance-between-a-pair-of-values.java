class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int ans=0;

        // for(int i=0; i<n1; i++){
        //     for(int j=i; j<n2; j++){
        //         if(nums1[i]<=nums2[j]){
        //             ans=Math.max((j-i), ans);

        //         }
        //     }
        // }
        // return ans;

        
        int i=0, j=0;

        while(i<n1 && j<n2){
            if(nums1[i]<=nums2[j]){
                ans=Math.max((j-i), ans);
                j++;
            }
            else{
                i++;
            }
        }
        return ans;
        
    }
}