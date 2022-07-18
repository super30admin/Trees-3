//Time complecity: o(n)
// space complexity: o(H)
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        helper(root, targetSum, new ArrayList<Integer>() , paths);
        return paths;
    }
    private void helper(TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> paths){
        if(root==null) return;
        curr.add(root.val);
        if(root.val == targetSum && root.left == null && root.right == null){
            paths.add(curr);
        }
        helper(root.left, targetSum-root.val, new ArrayList<Integer>(curr), paths);
        helper(root.right, targetSum-root.val, new ArrayList<Integer>(curr), paths);
    }
}



//Time complecity: o(n)
// space complexity: o(H)
// class Solution {
//     List<List<Integer>> result;
//     int target;
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         result = new ArrayList<>();
//         target = targetSum;
//         if(root == null) return result;
//         helper(root, 0, new ArrayList<>());
//         return result;
//     }

//     private void helper(TreeNode root, int currentsum, List<Integer> path){
//         //base case
//         if(root==null) return;
//         //logic
//         path.add(root.val);
//         currentsum = currentsum + root.val;
//         if(root.left == null && root.right == null && currentsum == target){
//             result.add(path);
//             return;
//         }
//         helper(root.left, currentsum, new ArrayList<>(path));
//         helper(root.right, currentsum, new ArrayList<>(path));
//     }
// }
