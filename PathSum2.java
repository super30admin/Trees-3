// //recursion deepcopy: For each recursive call, pass a new copy of the path list to avoid modifying previous paths.
// //Time Complexity: O(n^2) in the worst case (for skewed trees where each path copy takes O(N) time).
// //Space Complexity:O(n^2) for storing paths and recursive stack (in worst case skewed tree).
// class Solution {
//     List<List<Integer>> result;
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         this.result = new ArrayList<>();
//         List<Integer> path = new ArrayList<>();
//         helper(root, targetSum, 0, path);
//         return result;
//     }
//     private void helper(TreeNode root, int targetSum, int currNum, List<Integer> path){
//         if(root == null){
//             return;
//         }
//         path.add(root.val);
//         currNum += root.val;
//         if(root.left == null && root.right == null && targetSum == currNum){
//             result.add(new ArrayList<>(path));
//         }
//         helper(root.left, targetSum, currNum, new ArrayList<>(path));
//         helper(root.right, targetSum, currNum, new ArrayList<>(path));
//     }
// }

//backtracking
//Time Complexity:O(n)
//Space Complexity:O(h)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path){
        // base case
        if(root == null) return;
        //logic
        //action
        currSum += root.val;
        path.add(root.val);     
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        // recurse
        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);
        // backtrack
        path.remove(path.size()-1);
    }
}
