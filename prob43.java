// Time complexity -o[2**h] where h is the height of the tree
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
    List<List<Integer>> routes = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root,new ArrayList<>(),sum,0);
        return routes;
        
    }
    public void helper(TreeNode root, ArrayList<Integer> route, int target, int current){
        //base case
        if(root ==null) return;
        //Adding node into the path and updating the current sum
        route.add(root.val);
        current += root.val;
        //If the given node is a leaf node and value in current is equal to the target sum, add the arraylist route into routes
        if((root.left == null)&&(root.right==null)&&(current==target)) routes.add(new ArrayList<>(route));
        helper(root.left,route,target,current);
        helper(root.right,route,target,current);
        
        //Once all the elements till leaf are explored for a particular route, backtrack to find other combinations
        route.remove(route.size()-1);
    }
}