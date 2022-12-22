import java.util.ArrayList;
import java.util.List;

public class lowestCommonAncestor2 {
    boolean globalBool = false;
    boolean globalBoolFirst = false;
    boolean globalBoolSec = false;
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

        if(globalBool == false){
            globalBoolFirst = false;
            globalBoolSec = false;
            isDescendant(root, pVal, qVal);
        }
        if(globalBool == true){
            ans = root;
            ansList.add(ans);
        }
    }

    public void isDescendant(TreeNode subRoot, int pVal, int qVal){
        if(subRoot.val == pVal) globalBoolFirst = true;
        if(subRoot.val == qVal) globalBoolSec = true;
        if(globalBoolFirst && globalBoolSec)    globalBool = true;
        if(subRoot.left != null) isDescendant(subRoot.left, pVal, qVal);
        if(subRoot.right != null) isDescendant(subRoot.right, pVal, qVal);
    }
}