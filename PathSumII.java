
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathList = new ArrayList<List<Integer>>();
        List<Integer> pathNodes = new ArrayList<Integer>();
        checkPathSum(targetSum, root, pathNodes, pathList);
        return pathList;
    }

    void checkPathSum(int remainingSum, TreeNode node, List<Integer> res, List<List<Integer>> pathList){
        if(node==null) return;
        res.add(node.val);
        if(node.left==null && node.right==null && remainingSum==node.val){
            pathList.add(new ArrayList<>(res));
        }else{
            this.checkPathSum(remainingSum-node.val, node.left, res, pathList);
            this.checkPathSum(remainingSum-node.val, node.right, res, pathList);
        }

        //Backtract - remove the node from res after traversing to it's children
        res.remove(res.size()-1);
    }
}


//TC - O(N^2); // For traversing to each node and then copying the list into the solution list
//SC - O(N); //Memory of the recursion stack.