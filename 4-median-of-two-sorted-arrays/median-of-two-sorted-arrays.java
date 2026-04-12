class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int arr[]=new int[n1+n2];
      
        double ans=0;
        int i=0, j=0, k=0;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                arr[k]=nums1[i];
                i++;
                k++;
            }
            else if(nums1[i]>nums2[j]){
                arr[k]=nums2[j];
                k++;
                j++;

            }
            else{
                arr[k]=nums1[i];
                k++;
                arr[k]=nums2[j];
                k++;
                i++;
                j++;
            }

        }
        while(i<n1){
            arr[k]=nums1[i];
            k++;
            i++;
        }
        while(j<n2){
           arr[k]=nums2[j];
            k++;
            j++;
        }

        int n=arr.length;
        if(n%2==0){
            int a=arr[n/2];
            int b=arr[n/2-1];
            ans=((a+b)/2.0);
        }
        else{
            ans=(arr[n/2]);
        }
        return ans;


        
    }
}