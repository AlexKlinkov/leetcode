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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                var currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }

            result.add(currentLevel);
        }

        return result;
    }
}