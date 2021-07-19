//time n
//space n

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
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {

        List<Integer> currlist = new ArrayList<>();
        sum(root,targetSum,0,currlist);
        return res;
    }

    private void sum(TreeNode root, int targetSum , int currsum ,List<Integer> currlist )
    {
        //base
        if(root == null) return;

        //recursive
        currsum += root.val;
        currlist.add(root.val);

        if(root.left == null && root.right == null && currsum == targetSum)
        {
            List<Integer> lis = new ArrayList<>();
            lis.addAll(currlist);
            res.add(lis);
        }

        sum(root.left,targetSum,currsum,currlist);
        sum(root.right,targetSum,currsum,currlist);
        currlist.remove(currlist.size()-1);
    }
}
