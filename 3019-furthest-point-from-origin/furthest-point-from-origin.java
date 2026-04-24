class Solution {
    public int furthestDistanceFromOrigin(String s) {
        int n=s.length();
        int left=0;
        int right=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='R'){
                left--;
            }
            else{
                left++;
            }
        }

        for(int i=0; i<n; i++){
            if(s.charAt(i)=='L'){
                right--;
            }
            else{
                right++;
            }
        }
        return Math.max(left, right);




        
    }
}