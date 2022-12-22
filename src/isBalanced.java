import java.util.HashSet;
import java.util.Set;

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
class isBalanced {
    Set<Integer> recorder = new HashSet<>();
    public boolean isBalanced(TreeNode root) {
        // use recursion to exploit to find height (in height())
        // also use recursion to find heights for all the nodes (in main())
        if(root == null) return true;
        isBalanced(root.left);
        isBalanced(root.right);

        int diff = Math.abs(height(root.left) - height(root.right));
        recorder.add(diff);
        recorder.remove(0);
        recorder.remove(1);
        return recorder.size() == 0;
    }

    private int height(TreeNode root) {
        // An empty tree has height -1
        if (root == null) {
            return -1;
        }
        int fuck = 1 + Math.max(height(root.left), height(root.right));
        return fuck;
    }
}
