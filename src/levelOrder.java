import java.util.*;

public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        if(root == null) return answer;

        Queue<TreeNode> parseTree = new LinkedList<TreeNode>();
        parseTree.add(root);
        List<TreeNode> levelNodeHolder = new ArrayList<TreeNode>();

        answer.add(Arrays.asList(root.val));

        while(parseTree.peek() != null){
            // pop nodes out
            while(parseTree.peek() != null){
                TreeNode tempOut = parseTree.poll();
                // store child nodes of the nodes we just popped in levelNodeHolder
                levelNodeHolder.add(tempOut.left);
                levelNodeHolder.add(tempOut.right);
            }
            // add nodes in levelNodeHolder back in queue
            List<Integer> minorAns = new ArrayList<>();
            for(int i = 0; i<levelNodeHolder.size(); i++){
                if(levelNodeHolder.get(i) != null){
                    parseTree.add(levelNodeHolder.get(i));
                    minorAns.add(levelNodeHolder.get(i).val);
                }
            }
            if(minorAns.size() != 0)    answer.add(minorAns);
            levelNodeHolder.clear();
        }

        return answer;
    }
}
