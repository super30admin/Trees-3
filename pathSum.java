//Time Complexity : O(N)
//Space Complexity: O(N)
//We have used DFS approachto solve this question and then made recursive calls using l;eft and right subtree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //declaring a list which needs to be returned
        List<List<Integer>> paths = new ArrayList<>();
        //helper function
        findPaths(root,sum,new ArrayList<Integer>(),paths);
        return paths;

    }

    public void findPaths(TreeNode root, int sum ,List<Integer> current, List<List<Integer>> paths){

        //base condition
        if(root == null)
            return;

        //if we found the sum value in the root and left and right subtree are null
        current.add(root.val);
        if(root.val == sum && root.left == null && root.right == null){
            paths.add(current);
            return;
        }

        //recursive calls
        //each time the recursive call is being made a new ArrayList is being passed which has no previous values into it .
        findPaths(root.left,sum -root.val ,new ArrayList<Integer>(current),paths);
        findPaths(root.right,sum -root.val ,new ArrayList<Integer>(current),paths);



    }
}