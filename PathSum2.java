/* Time complexity: O(n*n)
space complexity: O(n*n)

*/

class Solution{
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> sumOfPath(TreeNode root, int sum){
        result = new ArrayList<>();
        target = sum;
        if(root == null) return result;
        dfs(root, 0, new ArrayList<>());
        return result;
    }

    public List<List<Integer>> dfs(TreeNode root, int currSum, List<Integer> temp){
        if(root == 0) return;
        currSum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(new ArrayList<>(temp));
            }
        }
        dfs(root.left, currSum, new ArrayList<>());
        dfs(root.righ, currSum, new ArrayList<>());
    }
}