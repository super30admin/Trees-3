/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // Time Complexity - O(n*n)
 // Space Complexity - O( n + maxDepth) - With recursive stack
 //                  - O(n) - without recursive stack
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        result = new ArrayList();

        if(root==null)
            return result;

        List<Integer> list = new ArrayList<>();
        list.add(root.val);

        helper(root,list,root.val,sum);
        return result;

    }

    private void helper(TreeNode curr, List<Integer> list, int currSum,int sum){

        if(curr.left == null && curr.right == null){

            if(currSum == sum){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if(curr.left != null){
            list.add(curr.left.val);
            helper(curr.left,list,currSum+curr.left.val,sum);
            list.remove(list.size()-1);
        }

         if(curr.right != null){
            list.add(curr.right.val);
            helper(curr.right,list,currSum + curr.right.val,sum);
            list.remove(list.size()-1);
        }

    }

}