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
        Stack<Integer> result = new Stack<>();

        TreeNode currentNode = root;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(currentNode);

        int count = 0;
        while (currentNode != null || !stack.isEmpty()) {

            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();

            if (count < k) {
                result.add(currentNode.val);
                if (count == k - 1) {
                    return result.peek();
                }
            }

            currentNode = currentNode.right;
            count++;
        }

        return result.peek();
    }
}