// Time Complexity : O(n), where n is equal to number of nodes, since we visit each node once
// Space Complexity : O(n), O(log n) for call stack + O(n) for maintaining a curPath list which we modify as we reach leaf nodes
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : storing the curPath till that level
// created copies of the current path till that level and passed to left and right child calls initially
// now keeping a single arraylist

// Your code here along with comments explaining your approach
// Approach is to use dfs, traverse from root till all leaf nodes, at the end where node.left==null && node.right==null check if curPathSum==sum
// maintain a curPath arraylist, at leaf node check if sum matches, create a copy and add to result
// when done processing left and right branches of the node, remove node from curPath and go up

class Solution {
    List<List<Integer>> paths = new ArrayList<List<Integer>>();
    int sum;

    private void dfs(TreeNode root, int curSum, List<Integer> curPath){
        curSum += root.val;
        curPath.add(root.val);

        if(root.left!=null){
            dfs(root.left, curSum, curPath);
        }
        if(root.right!=null){
            dfs(root.right, curSum, curPath);
        }

        else if(root.left==null && root.right==null){
            if(curSum==sum){
                paths.add(new ArrayList<Integer>(curPath));
            }
        }
        curPath.remove(curPath.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return paths;

        this.sum = sum;
        int curSum = 0;
        List<Integer> curPath = new ArrayList<Integer>();

        dfs(root, curSum, curPath);

        return paths;
    }
}