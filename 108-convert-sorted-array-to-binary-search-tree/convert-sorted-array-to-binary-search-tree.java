/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode helper(int []nums){
        int n=nums.length;
        if(n==0)return null;
        TreeNode node=new TreeNode(nums[n/2]);
        node.left=helper(Arrays.copyOfRange(nums, 0,n/2));
        node.right=helper(Arrays.copyOfRange(nums, (n/2)+1,n));

        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        TreeNode root=new TreeNode(nums[n/2]);
        root.left=helper(Arrays.copyOfRange(nums, 0,n/2));
        root.right=helper(Arrays.copyOfRange(nums, (n/2)+1, n));
        return root;
        

    }
}