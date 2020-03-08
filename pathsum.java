//o(n) time and o(n) memory
//passed all leetcode case
//used approach discussed in class

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        target = sum;
        if(root ==null) return result;
        dfs(root,0,new ArrayList<>());
        return result;
    }
    private void dfs(TreeNode root, int currsum, List<Integer> temp){
        //base
        if(root ==null) return;
        currsum +=root.val;
        temp.add(root.val);
        if(root.left==null&& root.right==null) {
            if(target==currsum) result.add(new ArrayList<>(temp));
        }
        dfs(root.left,currsum,temp);
        dfs(root.right,currsum,temp);
        temp.remove(temp.size()-1);
    }
}