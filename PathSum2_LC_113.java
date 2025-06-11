import java.util.ArrayList;
import java.util.List;

/*
Time Complexity Optimal: O(N) — You visit every node exactly once.
Space Complexity Optimal: O(H) — Due to recursion stack, where H is the height of the tree. In worst case (skewed tree), it becomes O(N).
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/



/*
 Brute Force - Creating Deep copy at every node
 Space complexity -O(H) recursive stack O(H) can become O(n) in worst case(skewed tree) plus we have list at every node so O(n*h)
 Time complexity - O(N) all the nodes traversal , and then we have deep copy at each node and deep copy will have H nodes so time complexity is O(n*h)
 */
class PathSum2_LC_113 {
    List<List<Integer>>path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        helper(root,0,curPath, targetSum);
        return path;
    }

    private void helper(TreeNode root, int curSum,List<Integer> curPath, int targetSum) {
        //base case
        if(root == null) return;
        //logic
        curSum +=root.val;
        List<Integer> li = new ArrayList<>(curPath);
        li.add(root.val);
        if(root.left == null && root.right == null) {
            if(targetSum == curSum) {
                //System.out.println(curPath);
                path.add(li);
            }
        }
        helper(root.left, curSum, li, targetSum);
        helper(root.right, curSum, li, targetSum);
    }
}


/*
optimal
pace complexity - O(H) for the recursion stack (H = tree height), O(N) in total output size if all paths are stored
time complexity - O(N)
*/

class Solution {
    List<List<Integer>>path;
    List<Integer> curPath;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path = new ArrayList<>();
        curPath = new ArrayList<>();
        helper(root,0, targetSum);
        return path;
    }

    private void helper(TreeNode root, int curSum, int targetSum) {
        //base case
        if(root == null) return;
        //logic
        curSum +=root.val;
        //List<Integer> li = new ArrayList<>(curPath);
        curPath.add(root.val);

        helper(root.left, curSum, targetSum);
        if(root.left == null && root.right == null) {
            if(targetSum == curSum) {
                System.out.println(curPath);
                path.add(new ArrayList<>(curPath));
            }
        }
        helper(root.right, curSum, targetSum);
        curPath.remove(curPath.size()-1);
    }
}