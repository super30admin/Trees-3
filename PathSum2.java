import java.util.*;

public class PathSum2 {
    public class TreeNode {
        int val;
        PathSum2.TreeNode left;
        PathSum2.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, PreorderInorder.TreeNode left, PreorderInorder.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    /*

    TC: O(n) as we are going over all the nodes of the tree
    SC: O(h) ==> O(n) in the worst case, the tree can be left skewed.

    */
        List<List<Integer>> result=new ArrayList<>();

        if(root==null) return result;

        helper(root,targetSum,0,new ArrayList<>(),result);

        return result;
    }

    public void helper(TreeNode root, int targetSum,int sum,List<Integer> path,List<List<Integer>> result){
        if(root==null){
            return;
        }

        int curSum=sum+root.val;
        path.add(root.val);

        if(root.left==null && root.right==null){
            if(curSum==targetSum){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        helper(root.left,targetSum,curSum,path,result);
        helper(root.right,targetSum,curSum,path,result);

        path.remove(path.size()-1);

    }
}
