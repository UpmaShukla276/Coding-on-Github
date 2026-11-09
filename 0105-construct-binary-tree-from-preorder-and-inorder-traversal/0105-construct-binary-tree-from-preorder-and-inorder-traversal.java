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

    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return construct(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode construct(int[] preorder, int[] inorder,
                              int start, int end) {

        // Step 1: No elements available
        if (start > end) {
            return null;
        }

        // Step 2: Get root from preorder
        int rootValue = preorder[preIndex];
        preIndex++;

        TreeNode root = new TreeNode(rootValue);

        // Step 3: Find root in inorder
        int index = 0;

        for (int i = start; i <= end; i++) {
            if (inorder[i] == rootValue) {
                index = i;
                break;
            }
        }

        // Step 4: Construct left subtree
        root.left = construct(preorder, inorder, start, index - 1);

        // Step 5: Construct right subtree
        root.right = construct(preorder, inorder, index + 1, end);

        // Step 6: Return completed root
        return root;
    }
}
