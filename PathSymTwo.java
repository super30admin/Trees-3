import java.util.*;
public class PathSymTwo {
    List<List<Integer>> result;

    int target;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        result = new ArrayList<>();

        target = sum;

        if(root == null) return result;

        dfs(root, 0, new ArrayList<>());

        return result;

    }

    private void dfs(TreeNode root, int currSum, List<Integer> temp){

        // Base

        if(root == null) return;

        currSum += root.val;

        temp.add(root.val);

        if(root.left == null && root.right == null){

            if(target == currSum){

                result.add(new ArrayList<>(temp));

            }

        }

        dfs(root.left, currSum, temp);

        dfs(root.right, currSum, temp);

        // backtrack

        temp.remove(temp.size() - 1);

    }

    public static void main(String[] args) {
        PathSymTwo tree = new PathSymTwo();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int target=22;
        System.out.println(tree.pathSum(root,target));
    }

}

