import java.util.*;

public class invertTree2{
    // recursion 因为所有的 sub tree 都在做同样的事情，所以可以先 exploit 到最底部（左）
    // 然后回爬的时候把 sub-root 的 right 也给拿来 invert，如果right不是Leaf，那就exploit right！
    public TreeNode invertTree4(TreeNode root){
        if(root != null){
            invertTree4(root.left);
            invertTree4(root.right);

            // 这个用来帮助我理解 back trace 的过程
            if(root.left != null && root.right != null){
                System.out.println(root.left.val);
                System.out.println(root.right.val);
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

    public TreeNode invertTree3(TreeNode root){
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while(queue.isEmpty() == false){
                TreeNode out = queue.poll();
                if(out != null){
                    TreeNode temp = out.right;
                    out.right = out.left;
                    out.left = temp;
                    queue.add(out.left);
                    queue.add(out.right);
                }

            }
        }
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
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

        // connect them all
        for(int a = 0; a<nodeArray.size()-1; a++){
            for(int b = 0; b<nodeArray.get(a).size() ;b++){
                if(nodeArray.get(a).get(b) != null){
                    nodeArray.get(a).get(b).left = nodeArray.get(a+1).get(2*b+1);
                    nodeArray.get(a).get(b).right = nodeArray.get(a+1).get(2*b);
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
