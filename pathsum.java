/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// time: O(n) n is number of nodes
// space: O(h) height of tree
class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list=new ArrayList<>();
        dfs(root,list,0,sum);
        return result;
    }
    private void dfs(TreeNode root,List<Integer> curr,int currSum,int sum)
    {
        if(root==null) return;
        currSum+=root.val;
        curr.add(root.val);
        if(root.left==null && root.right==null)
        {
            if(currSum==sum)
            {
                result.add(new ArrayList<>(curr));
            }
        }
        dfs(root.left,curr,currSum,sum);
        dfs(root.right,curr,currSum,sum);
        curr.remove(curr.size()-1);
    }
}