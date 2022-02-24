import java.util.ArrayList;
import java.util.List;

/*
Time complexity: O(N)
Space Complexity: O(N)
Run on Leetcode: Yes
Any difficulties: no

Approach
1. Recursively iterating on the height of the tree and keep on subtracting root values from the given target sum
2. Edge condition would be if the sum becomes zero add all the list values in the result
 */
public class PathSumII {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> pathSumII(TreeNode root, int target){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        recurseOnTheTree(root, target-root.val, list, result );
        return result;
    }

    public static void recurseOnTheTree(TreeNode root, int pathsum, List<Integer> list, List<List<Integer>>result){
        if(root.left == null && root.right == null && pathsum == 0){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            result.add(temp);
        }
        if(root.left!= null){
            list.add(root.left.val);
            recurseOnTheTree(root.left, pathsum-root.left.val, list, result );
            list.remove(list.size()-1);
        }
        if(root.right!= null){
            list.add(root.right.val);
            recurseOnTheTree(root.right, pathsum-root.right.val, list, result );
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSumII(root, 22));
    }
}
