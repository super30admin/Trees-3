import java.util.ArrayList;
import java.util.List;

//Time Complexity=O(n)
//Space Complexity=O(H)
public class PathSumII {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new ArrayList();
        if(root==null){
            return result;
        }

        helper(root,0,new ArrayList<>(),targetSum);
        return result;
    }

    private void helper(TreeNode root, int currSum, List<Integer> path, int targetSum){

        if(root==null){
            return ;
        }
        currSum+=root.val;

        //action
        path.add(root.val);
        // System.out.println(path);

        if(root.left==null && root.right==null){
            if(currSum==targetSum){
                result.add(new ArrayList<>(path));
            }
        }

        //recurse
        helper(root.left,currSum,path,targetSum);
        helper(root.right,currSum,path,targetSum);

        //backtrack
        path.remove(path.size()-1);
    }
}
