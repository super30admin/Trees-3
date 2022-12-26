// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
class Solution {
List<List<Integer>> paths = new ArrayList<>(); 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        findPaths(root, targetSum, new ArrayList<Integer>(), paths);

        return paths;
    }

    public void findPaths(TreeNode root, int sum, List<Integer> current, List<List<Integer>> paths){
        if( root == null) return;
        current.add(root.val);

        if(root.val == sum && root.left == null && root.right == null){
            paths.add(current);
            return; // early return
        }

        findPaths(root.left, sum - root.val, new ArrayList<Integer>(current),paths);
        findPaths(root.right, sum - root.val, new ArrayList<Integer>(current),paths);
    }
}
