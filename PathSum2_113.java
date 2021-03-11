import java.util.*;

//TC: O(N) - Since we are traversing all the elements in the tree. 
//SC: O(N) - Height of the tree. Because of the recursive call stack.
public class PathSum2_113 {

    public List<List<Integer>> pathSum(TreeNode tree, int target) {
        List<List<Integer>>  result = new ArrayList<List<Integer>>(); //It expects empty array instead null;
        if(tree == null) return result;
        return helper(tree, target, 0, null, result);

    }

    //Increase the current sum
    //add to the path.
    //Once we reach the leaf node, update the result list with current traversed path.
    //If we still have the left node, travers again and delete the left traversed element.
    //If we still have the right node, travers again and delete the right traversed element.
    //return the result.
    private List<List<Integer>> helper(TreeNode tree, int target, int currentSum, List<Integer> currentPath, List<List<Integer>> result)  {
        if(tree == null) return result;
        if(currentPath == null){
            currentPath = new ArrayList<Integer>();
        }

        currentSum += tree.val;
        currentPath.add(tree.val);


        if(tree.left == null && tree.right ==null) {
            if(currentSum == target) {
                ArrayList<Integer> successPath = new ArrayList<Integer>(currentPath);
                result.add(successPath);
                return result;
            }
        }

        if(tree.left !=null) {
            helper(tree.left, target, currentSum, currentPath, result);
            //Current path is temporary, since we added to the result list, we don't need to want the last item we traversed. 
            currentPath.remove(currentPath.size()-1); 


        }
        if(tree.right !=null) {
            helper(tree.right, target, currentSum, currentPath, result);
            //Current path is temporary, since we added to the result list, we don't need to want the last item we traversed. 
            currentPath.remove(currentPath.size()-1);
        }
        return result;
    }


    public static void main(String[] args) {
        PathSum2_113 pathSum2_113 = new PathSum2_113();
        TreeNode tree = new TreeNode();
        TreeNode sample = tree.getSampleTwo();
        List<List<Integer>> result = pathSum2_113.pathSum(sample, 22);
        System.out.println("The result is"+ result);
    }
}
