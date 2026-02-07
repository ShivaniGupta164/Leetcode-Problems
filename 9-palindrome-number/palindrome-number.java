class Solution {
    public boolean isPalindrome(int x) {
        int sum=0;
        int original=x;
        while(x>0){
            int rem=x%10;
            sum=sum*10+rem;
            x=x/10;
        }
        if(sum!=original){
            return false;
        }
        return true;
        
    }
}