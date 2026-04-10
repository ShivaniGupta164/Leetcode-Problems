class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer>ans=new HashSet<>();
        for(int i=0; i<n; i++){
            ans.add(nums[i]);

        }
        int longest=0;
        
        for(int num : ans){
            if(!ans.contains(num-1)){
                int currentNum=num;
                int currentStreak=1;

                while(ans.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;


                }
                longest=Math.max(longest, currentStreak);

            }
        }

      
        return longest;


        
    }
}