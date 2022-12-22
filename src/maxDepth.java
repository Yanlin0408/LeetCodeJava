public class maxDepth {
    int jj = 0;

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int nn = (getHeight(root.left) > getHeight(root.right)) ? getHeight(root.left) : getHeight(root.right);
        return nn+1;
    }

    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        return height;
    }
}
