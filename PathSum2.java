

// TC : O(n)
// SC : O(h)

package S30_Codes.Trees_3;
import java.util.ArrayList;
import java.util.List;

class PathSum2 {
    List<List<Integer>> ans;
    List<Integer> curPath;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        curPath = new ArrayList<>();

        checkPathSum(root, targetSum);
        return ans;
    }

    private void checkPathSum(TreeNode node, int targetSum){
        if(node == null)
            return;

        curPath.add(node.val);
        targetSum -= node.val;

        if(targetSum == 0 && node.left == null && node.right == null)
            ans.add(new ArrayList<>(curPath));

        checkPathSum(node.left, targetSum);
        checkPathSum(node.right, targetSum);

        curPath.remove(curPath.size()-1);
    }
}