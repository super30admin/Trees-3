
// Time Complexity :O(N^2) because we traverse the entire tree in worst case and N is the number of treenodes.
// for every leaf node, we perform a copying operation of the path nodes to a new arraylist which results in one mone N.
//so worst case O(N^2)
// Space Complexity :O(n) space used by recursive stack
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
 // We will do a DFS and look for the path that adds up to the desired target
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        target = sum;
        if(root == null) return result;
        dfs(root, 0, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int currSum, List<Integer> temp){
        // Base case
        if(root == null) return;
        currSum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(target == currSum){
                result.add(new ArrayList<>(temp));
            }
        }
        // logic
        // recursion to add the path ,currSum and list temp to the recursive stack
        dfs(root.left, currSum, temp);
        dfs(root.right, currSum, temp);
        // backtrack
        //to remove the path that doesnt add up to target
        temp.remove(temp.size() - 1);

    }




}