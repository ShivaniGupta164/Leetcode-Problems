class Solution {
    int memo[301][27][27]; // Storage to remember previous results
public:
    int getDist(int src, int dest) {
        if (src == 26) return 0; // 26 represents the finger not yet placed
        int x1 = src / 6, y1 = src % 6;
        int x2 = dest / 6, y2 = dest % 6;
        return abs(x1 - x2) + abs(y1 - y2);
    }

    int solve(string& word, int idx, int f1, int f2) {
        if (idx == word.length()) return 0;
        
        // If we've already calculated this state, return it immediately
        if (memo[idx][f1][f2] != -1) return memo[idx][f1][f2];

        int currChar = word[idx] - 'A';

        // Option 1: Move Finger 1
        int moveF1 = getDist(f1, currChar) + solve(word, idx + 1, currChar, f2);

        // Option 2: Move Finger 2
        int moveF2 = getDist(f2, currChar) + solve(word, idx + 1, f1, currChar);

        // Save the result in memo before returning
        return memo[idx][f1][f2] = min(moveF1, moveF2);
    }

    int minimumDistance(string word) {
        // Initialize memo with -1 (meaning "uncalculated")
        memset(memo, -1, sizeof(memo));
        // Use 26 instead of -1 for the fingers to fit in array indices
        return solve(word, 0, 26, 26);
    }
};