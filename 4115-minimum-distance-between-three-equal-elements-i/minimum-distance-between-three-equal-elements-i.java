class Solution {
    public int minimumDistance(int[] arr) {
        int n=arr.length;
        int count=0;
        int ans=-1;
        if(n<3)return -1;
    
        int smallDiff=Integer.MAX_VALUE;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1;j++){
                for(int k=j+1; k<n; k++){
                    if(arr[i]==arr[j] && arr[j]==arr[k]){
                        count=count+3;
                        
                        smallDiff=Math.min((Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i)),smallDiff);
                        
                    }
                    
                }
            }
        }
        if(count<3)return -1;
       
        return smallDiff;
         
    }
}