import java.util.ArrayList;
import java.util.List;

public class lowestCommonAncestor {
    boolean globalBool = false;
    List<TreeNode> ansList = new ArrayList<TreeNode>();
    TreeNode ans = new TreeNode();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        looper(root,p.val,q.val);
        return ansList.get(0);
    }

    public void looper(TreeNode root, int pVal, int qVal){
        if(root.left != null) looper(root.left, pVal, qVal);
        if(root.right != null) looper(root.right, pVal, qVal);

        isDescendant(root, pVal);
        if(globalBool == true){
            globalBool = false;
            isDescendant(root, qVal);
        }

        if(globalBool == true){
            ans = root;
            ansList.add(ans);
        }
    }

    public void isDescendant(TreeNode subRoot, int treeVal){
        if(subRoot.val == treeVal) globalBool = true;
        if(subRoot.left != null) isDescendant(subRoot.left, treeVal);
        if(subRoot.right != null) isDescendant(subRoot.right, treeVal);
    }
}
