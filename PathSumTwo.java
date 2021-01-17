import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

// Time Complexity :O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class PathSumTwo {

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {

            List<List<Integer>> paths = new ArrayList<>();

            findPaths(root, sum, new ArrayList<>(), paths);

            return paths;
        }

        void findPaths(TreeNode root, int sum, List<Integer> current, List<List<Integer>> paths){
            //base case
            if(root == null) return;

            //add current root to list
            current.add(root.val);

            //if root value is equals to sum and we are at lead node then return
            if(root.val == sum && root.left == null & root.right == null){
                paths.add(current);
                return;
            }

            //check left and right childs
            findPaths(root.left, sum-root.val, new ArrayList<Integer>(current), paths);
            findPaths(root.right, sum-root.val, new ArrayList<Integer>(current), paths);
        }
    }








}
