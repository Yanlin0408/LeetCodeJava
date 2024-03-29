import java.util.ArrayList;
import java.util.List;

class levelOrder2 {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    public void helper(TreeNode node, int level){
        // if(node != null) System.out.println(node.val);
        if(levels.size() == level) levels.add(new ArrayList<Integer>());

        levels.get(level).add(node.val);

        if(node.left != null) helper(node.left,level+1);
        if(node.right != null) helper(node.right,level+1);
    }

    public List<List<Integer>> levelOrder2(TreeNode root){
        if(root == null) return levels;
        helper(root,0);
        return levels;
    }
}
