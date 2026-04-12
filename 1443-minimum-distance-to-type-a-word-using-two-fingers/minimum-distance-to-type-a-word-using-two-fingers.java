class Solution {
    
    int[][][] dp;
    
    public int minimumDistance(String word) {
        int n = word.length();
        dp = new int[n][27][27];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<27;j++){
                for(int k=0;k<27;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return solve(word, 0, 26, 26); // 26 means "no finger placed yet"
    }
    
    private int solve(String word, int idx, int f1, int f2) {
        if(idx == word.length()) return 0;
        
        if(dp[idx][f1][f2] != -1) return dp[idx][f1][f2];
        
        int curr = word.charAt(idx) - 'A';
        
        // Move finger1
        int cost1 = distance(f1, curr) + solve(word, idx + 1, curr, f2);
        
        // Move finger2
        int cost2 = distance(f2, curr) + solve(word, idx + 1, f1, curr);
        
        return dp[idx][f1][f2] = Math.min(cost1, cost2);
    }
    
    private int distance(int a, int b) {
        if(a == 26) return 0; // finger not placed
        
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}