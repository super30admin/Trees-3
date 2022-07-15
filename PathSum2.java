// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    int target;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        target = targetSum;
        helper(root,0);
        return res;
    }
    void helper(TreeNode cur, int curSum){
        if(cur == null){
            return;
        }
        path.add(cur.val);
        curSum = curSum + cur.val;
        if(cur.left == null && cur.right == null){
            if(curSum == target){
                res.add(new ArrayList<>(path));
            }
        }
        helper(cur.left,curSum);
        helper(cur.right,curSum);
        path.remove(path.size()-1);
    }
}