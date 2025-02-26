import java.util.ArrayList;
import java.util.List;

public class PathSumTwo {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        helper(root,path,targetSum);
        return output;
        
    }
    public void helper(TreeNode curr,List<Integer> path, int target){
        if(curr == null) return;
        path.add(curr.val);
        target = target - curr.val;
        if(curr.left==null && curr.right == null && target == 0){
                output.add(new ArrayList<>(path));
        }
        else{
            if(curr.left!=null) helper(curr.left,path,target);
            if(curr.right!=null) helper(curr.right,path,target);
        }
        path.remove(path.size() - 1);
    }
}
