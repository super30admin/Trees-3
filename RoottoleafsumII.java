import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

class RoottoleafsumII{
        List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        dfs(root,targetSum,0,new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int targetsum, int runningsum, List<Integer> path)
    {
        if(root==null)
        {
            return;
        }
        else
        {
            path.add(root.val);
            runningsum += root.val;
            if(root.left==null && root.right==null){
            if(runningsum == targetsum)
            {
                result.add(new ArrayList<>(path));
            }
            }
            dfs(root.left,targetsum,runningsum,path);
            dfs(root.right,targetsum,runningsum,path);
            path.remove(path.size()-1);
        }
        
    }
}