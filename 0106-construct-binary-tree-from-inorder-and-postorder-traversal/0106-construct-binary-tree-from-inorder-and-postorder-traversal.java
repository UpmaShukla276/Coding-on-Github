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
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        return construct(inorder, postorder, 0, inorder.length-1); 
    }
    public TreeNode construct(int[] inorder, int[] postorder, int start, int end){
        if(start>end){
            return null;
        }
        int rootValue = postorder[postIndex];
        postIndex--;

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == rootValue) {
                index = i;
                break;
            }
        }

        // Construct RIGHT subtree first
        root.right = construct(inorder, postorder, index + 1, end);

        // Construct LEFT subtree
        root.left = construct(inorder, postorder, start, index - 1);

        return root;
    }
}