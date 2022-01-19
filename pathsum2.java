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

Time:O(n);
 Space:O(1); As we are returing same arary;
class Solution {
    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // List <Integer> iL=new ArrayList<>();
        List <Integer> iL=new ArrayList<>();
        helper(root,targetSum,iL);
        return result;
    }

    public void helper(TreeNode node,int targetSum,List<Integer> iL){
        // System.out.println("node.val = "+node.val + " targetSum = "+targetSum + " iL = "+iL);
        if(node==null){
            if(targetSum==0){
                System.out.println(" targetSum = "+targetSum + " iL = "+iL);

                result.add(new ArrayList(iL));

            }
            return;
        }
        System.out.println("node.val = "+node.val + " targetSum = "+targetSum + " iL = "+iL);

        targetSum=targetSum-node.val;
        iL.add(node.val);
        System.out.println("iL before left helper = "+iL);
        helper(node.left,targetSum,iL);
        System.out.println("iL after left helper = "+ iL);
        if(node.right!=null){
            helper(node.right,targetSum,iL);
        }

        iL.remove(iL.size()-1);

    }
}