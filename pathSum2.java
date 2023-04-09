/*
 * Time -  O(N) where N is the number of nodes in the tree.
 * Space - O(H) where H is the height, H = N when the tree is fully skewed.
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        getPaths(root, targetSum, 0, path, paths);
        return paths;
    }

    public void getPaths(TreeNode root, int targetSum, int currSum, List<Integer> path, List<List<Integer>> paths) {
        if(root == null)    
            return;
        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null){
            if(targetSum == currSum)
                paths.add(new ArrayList<Integer> (path));
        } 
        else {
            getPaths(root.left, targetSum, currSum, path, paths);
            getPaths(root.right, targetSum, currSum, path, paths);
        }
        path.remove(path.size() - 1);
    }
}
