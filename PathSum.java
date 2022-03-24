// Time Complexity : O(n^2)
// Space Complexity :  O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    //method1 without comment method2
    //n^2 both time and space
    List<List<Integer>> result;
    private void helper(TreeNode root, int currSum, List<Integer> path, int target){
        //base
        if(root == null)return;
        //logic
        currSum+=root.val;
        path.add(root.val);
        //this is inorder we can also have preorder and postorder
        //helper(root.left, currSum,  new ArrayList<>(path), target);
        helper(root.left, currSum, path, target);
        if(root.left == null && root.right == null){
            if(target == currSum){
                //result.add(path);
                result.add(new ArrayList<>(path));
                
            }
        }        
        //helper(root.right, currSum,  new ArrayList<>(path), target);
        helper(root.right, currSum, path, target);
        
        //backtrack for reducing complexities
        path.remove(path.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root,0,new ArrayList<>(),targetSum);
        return result;
    }
}