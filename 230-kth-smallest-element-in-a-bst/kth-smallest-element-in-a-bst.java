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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        
        int count = 0;
        while (currentNode != null || !stack.isEmpty()) {
            // Reach the leftmost node
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            count++;

            // When count reaches k, we found our answer
            if (count == k) {
                return currentNode.val;
            }

            // Move to right subtree
            currentNode = currentNode.right;
        }

        return -1; // k is invalid (greater than tree size)
    }
}