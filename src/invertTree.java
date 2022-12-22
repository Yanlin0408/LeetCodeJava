import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
class invertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        // traverse, store the Tree into an ArrayList
        List<List<TreeNode>> nodeArray = new ArrayList<>();
        TreeNode dummyR = root;
        List<TreeNode> subArray = new ArrayList<>();
        subArray.add(dummyR);
        nodeArray.add(subArray);
        Boolean caobi = true;
        int counter = 0;
        while(caobi){
            List<TreeNode> curArray = new ArrayList<>();
            for(TreeNode t: nodeArray.get(counter)){   // 这 get 拿到的是 curArray，所以改变了curArray就会诱发 concurrentModification
                if(t != null){
                    curArray.add(t.left);
                    curArray.add(t.right);
                }else{
                    curArray.add(null);
                    curArray.add(null);
                }
            }
            nodeArray.add(curArray);    // 把 curArray 塞入 nodeArray，下一轮再找 curArray 的所有的 left and right node
            counter++;
            if(ifAllNull(curArray))
                caobi = false;
        }

        // rearrange the nodeArray in a inverted way
        for(int k = 0; k<nodeArray.size(); k++){
            Collections.reverse(nodeArray.get(k));
        }

        // connect them all
        for(int a = 0; a<nodeArray.size()-1; a++){
            for(int b = 0; b<nodeArray.get(a).size() ;b++){
                if(nodeArray.get(a).get(b) != null){
                    nodeArray.get(a).get(b).left = nodeArray.get(a+1).get(2*b);
                    nodeArray.get(a).get(b).right = nodeArray.get(a+1).get(2*b+1);
                }
            }
        }

        return dummyR;
    }
    public Boolean ifAllNull(List theList){
        Iterator<TreeNode> it = theList.iterator();
        while(it.hasNext()){
            if(it.next() != null) return false;
        }
        return true;
    }
}
