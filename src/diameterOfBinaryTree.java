public class diameterOfBinaryTree {
    int jj = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        int aa = getHeight(root.left) + getHeight(root.right) + 2;
        jj = (jj > aa) ? jj : aa;
        return jj;
    }

    public int getHeight(TreeNode root){
        if(root == null) return -1;
        int height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        return height;
    }
}
