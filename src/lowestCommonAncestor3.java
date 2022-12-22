public class lowestCommonAncestor3 {

    private TreeNode ans;

    public lowestCommonAncestor3() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if(currentNode == null) return false;
        System.out.println(currentNode.val);
        int left = recurseTree(currentNode.left,p,q)?1:0;
        int right = recurseTree(currentNode.right,p,q)?1:0;

        System.out.println("---"+currentNode.val+" left "+left+" right "+right);

        int mid = 0;
        if(currentNode == p || currentNode == q)    mid = 1;

        if(left+right+mid == 2){
            this.ans = currentNode;
        }

        return (left+right+mid) >= 1;
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}