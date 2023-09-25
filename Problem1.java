import java.util.ArrayList;
import java.util.List;

//T.C  : O(n)
//S.C : O(h)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
public class Problem1 {

    public class TreeNode {
        int val;
        Problem2.TreeNode left;
        Problem2.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Problem2.TreeNode left, Problem2.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root == null) return res;
        inorder(root,targetSum,0,new ArrayList<>());
        return res;

    }

    private void inorder(TreeNode root ,int targetSum , int currSum ,List<Integer> ds){
        if(root == null) return ;
        ds.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum+root.val ==  targetSum ){
                res.add(new ArrayList<>(ds));
            }
        }
        inorder(root.left, targetSum,currSum+root.val,ds);


        inorder(root.right, targetSum,currSum+root.val,ds);
        ds.remove(ds.size()-1);

    }
}
