/**
// Time Complexity : O(n)
// Space Complexity : O(m) space to store all the paths  == trgt
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
  nope

// Your code here along with comments explaining your approach
 */
class Solution {
    private void helper(TreeNode node, int trgt, List<List<Integer>> ret,
                        int sum, LinkedList<Integer> temp){
        if(node == null)
            return ;

        //do preorder traversal.
        temp.addLast(node.val);
        sum += node.val;
        if(sum == trgt && node.right == null && node.left == null){
            //if sum == target, add linkedlist to ret list.
            List<Integer> lst = new ArrayList<>(temp);
            ret.add(lst);
        }

        helper(node.left, trgt, ret, sum, temp);
        helper(node.right, trgt, ret, sum, temp);

        //remove last elem (this node val) from linkedlist.
        temp.removeLast();
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> ret = new ArrayList<>();
        helper(root, sum, ret, 0, new LinkedList<>());
        return ret;
    }
}
