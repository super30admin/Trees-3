import java.util.ArrayList;
import java.util.List;

//Approach - recursive global variables
//Time - O(n)
//Space - O(n) due to arraylists
class PathSumII {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return new ArrayList<>();
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(root, 0, targetSum);
        return result;
    }
    public void helper(TreeNode root, int currSum, int target){
        if(root==null) return;

        path.add(root.val);

        if(root.left==null && root.right==null){
            currSum = currSum + root.val;
            if(currSum == target){
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.left, currSum+root.val, target);
        helper(root.right, currSum+root.val, target);

        path.remove(path.size()-1);

    }
}
